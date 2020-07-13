package com.uss.validationtests.auth;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.util.Base64URL;
import com.uss.validationtests.auth.models.KeyContainer;
import com.uss.validationtests.auth.models.TokenResponse;
import com.uss.validationtests.exceptions.FailToRetrieveKeyException;
import com.uss.validationtests.services.PropertiesConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Form;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.uss.validationtests.utils.Utils.jsonToPojo;

@Component
public class AuthTokenGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthTokenGenerator.class);

    @Autowired
    private final PropertiesConfig propertiesConfig;

    @Autowired
    private final WellKnownUrlResolver urlResolver;

    private final String fimsAuthzHostName;
    private final String clientId;

    public AuthTokenGenerator(PropertiesConfig propertiesConfig, WellKnownUrlResolver urlResolver) {
        this.propertiesConfig = propertiesConfig;
        this.urlResolver = urlResolver;
        this.fimsAuthzHostName = propertiesConfig.getFimsAuthzUrl();
        this.clientId = propertiesConfig.getClientId();
    }

    public TokenResponse retrieveNewToken(List<String> scope, Map<String, String> additionalFormParams) throws IOException {
        String scopeOneLine = String.join(" ", scope);

        Form data = new Form();
        data.param("grant_type", "client_credentials");
        data.param("scope", scopeOneLine);
        data.param("client_id", clientId);
        data.param("current_timestamp", ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT));
        additionalFormParams.forEach(data::param);

        String body = getDataString(data);
        String signature = "";
        try {
            signature = stripOffPayloadFromSignature(getSignature(body));
        } catch (JOSEException | GeneralSecurityException e) {
            LOGGER.error("Cannot sign the message", e);
        }

        HttpPost post = new HttpPost(fimsAuthzHostName);
        post.addHeader("content-type", "application/x-www-form-urlencoded");
        post.addHeader("x-utm-message-signature", signature);

        StringEntity entity = new StringEntity(body, StandardCharsets.UTF_8);
        post.setEntity(entity);
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {
            return jsonToPojo(EntityUtils.toString(response.getEntity(), "UTF-8"), TokenResponse.class);
        }
    }

    private String getDataString(Form data) {
        StringBuilder sb = new StringBuilder();
        data.asMap().forEach((key, value) -> sb.append(key).append("=").append(value.get(0)).append("&"));
        return sb.toString().substring(0, sb.length() - 1);
    }

    private String stripOffPayloadFromSignature(String signature) {
        // As per the FIMS AZ spec, it is decided to strip off the encoded payload from the signature before injecting
        // in headers in order to avoid performance issues
        return signature.replaceAll("\\..*\\.", "..");
    }

    private String getSignature(String payload) throws JOSEException, GeneralSecurityException {
        KeyContainer currentPair = getSigningKeyPair();

        JWSSigner signer = new RSASSASigner(currentPair.getPrivateKey());

        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256).
            type(JOSEObjectType.JOSE)
            .keyID(currentPair.getKid())
            .x509CertURL(currentPair.getUri())
            .x509CertSHA256Thumbprint(new Base64URL(currentPair.getThumbprint()))
            .build();

        JWSObject jwsObject = new JWSObject(header, new Payload(payload));

        // Compute the RSA signature
        jwsObject.sign(signer);

        return jwsObject.serialize();
    }

    private KeyContainer getSigningKeyPair() throws GeneralSecurityException {
        String keyFilePath = getPrivateKeyFilePath();
        PrivateKey privateKey = null;
        Certificate certificate;

        if (null != keyFilePath && 0 != keyFilePath.trim().length()) {
            try {
                privateKey = loadDerPrivateKey(keyFilePath);
            } catch (IOException ex) {
                throw new FailToRetrieveKeyException("Private key load failed", ex);
            }
        }
        String certFilePath = getCertificateFilePath();
        if (null == certFilePath || 0 == certFilePath.trim().length()) {
            throw new FailToRetrieveKeyException("Certificate file is not provided");
        }
        try {
            certificate = loadDerCertificate(certFilePath);
        } catch (Exception ex) {
            throw new FailToRetrieveKeyException("Certificate load failed", ex);
        }
        return buildKeyContainer(privateKey, certificate, urlResolver);
    }

    //TODO: Notify Valtest owner about these paths
    private String getCertificateFilePath() {
        return getClass().getClassLoader().getResource("uss.x509.pub.cert.der").getPath();
    }

    //TODO: Notify Valtest owner about these paths
    private String getPrivateKeyFilePath() {
        return getClass().getClassLoader().getResource("uss.private.key.der").getPath();
    }

    private static PrivateKey loadDerPrivateKey(String keyFile) throws GeneralSecurityException, IOException {
        KeyFactory kf = KeyFactory.getInstance("RSA");

        File f = new File(keyFile);
        byte[] keyBytes = new byte[(int) f.length()];
        try (DataInputStream dis = new DataInputStream(new FileInputStream(f))) {
            dis.readFully(keyBytes);
        }
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);

        return kf.generatePrivate(spec);
    }

    private static Certificate loadDerCertificate(String filename) throws CertificateException, FileNotFoundException {

        CertificateFactory fact = CertificateFactory.getInstance("X.509");
        FileInputStream is = new FileInputStream(filename);
        Certificate cer = fact.generateCertificate(is);
        return cer;
    }

    private static KeyContainer buildKeyContainer(PrivateKey privateKey, Certificate certificate, WellKnownUrlResolver urlResolver)
        throws CertificateEncodingException, NoSuchAlgorithmException {
        byte[] der = certificate.getEncoded();

        String kid = nameUUID5FromBytes(der).toString();
        String thumbprint = calculateThumbprint(der);

        URI uri = urlResolver.resolve(kid + ".der");

        return new KeyContainer(kid, privateKey, certificate, thumbprint, uri);
    }

    private static UUID nameUUID5FromBytes(byte[] name) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException nsae) {
            throw new InternalError("SHA-1 not supported", nsae);
        }
        byte[] sha1Bytes = md.digest(name);
        sha1Bytes[6] &= 0x0f;  /* clear version        */
        sha1Bytes[6] |= 0x50;  /* set to version 5     */
        sha1Bytes[8] &= 0x3f;  /* clear variant        */
        sha1Bytes[8] |= 0x80;  /* set to IETF variant  */

        long msb = 0;
        long lsb = 0;
        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | (sha1Bytes[i] & 0xff);
        }
        for (int i = 8; i < 16; i++) {
            lsb = (lsb << 8) | (sha1Bytes[i] & 0xff);
        }
        return new UUID(msb, lsb);
    }

    private static String calculateThumbprint(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(bytes);

        return Base64URL.encode(md.digest()).toString();
    }
}
