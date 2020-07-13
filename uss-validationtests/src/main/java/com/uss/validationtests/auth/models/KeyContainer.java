package com.uss.validationtests.auth.models;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

public class KeyContainer implements IPublicKeyContainer, ICertificateContainer {

    @NotNull
    @Getter
    private String kid;

    @Getter
    private PrivateKey privateKey;

    @NotNull
    @Getter
    private PublicKey publicKey;

    @Getter
    private Certificate certificate;

    @Getter
    private String thumbprint;

    @Getter
    private URI uri;

    public KeyContainer(String kid, PublicKey publicKey) {
        this.kid = kid;
        this.publicKey = publicKey;
    }

    public KeyContainer(String kid,
                        PrivateKey privateKey,
                        Certificate certificate,
                        String thumbprint,
                        URI uri) {
        this.kid = kid;
        this.privateKey = privateKey;
        this.certificate = certificate;
        this.thumbprint = thumbprint;
        this.publicKey = certificate.getPublicKey();
        this.uri = uri;
    }

    @Override
    public boolean isForeign() {
        return (null == privateKey);
    }
}
