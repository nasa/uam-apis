package com.uss.validationtests;

import com.uss.validationtests.auth.AuthTokenGenerator;
import com.uss.validationtests.auth.models.TokenResponse;
import com.uss.validationtests.models.ErrorResponseMessage;
import com.uss.validationtests.models.HttpResponse;
import com.uss.validationtests.services.HttpClient;
import com.uss.validationtests.swagger.PutOperationDetailsParameters;
import com.uss.validationtests.utils.Utils;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UssPostOperationsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UssPostOperationsTest.class);
    private static final String USS_OPERATIONS_PATH = "uss/v1/operations";
    List<String> scopes = Arrays.asList("utm.strategic_coordination", "utm.constraint_consumption");

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private AuthTokenGenerator authTokenGenerator;

    private TokenResponse tokenResponse;
    private Map<String, String> tokenHeader = new HashMap<>();
    private List<String> requestUrlParams = new ArrayList<>();
    private String uuid;

    @Before
    public void setup() throws IOException {
        requestUrlParams.add(USS_OPERATIONS_PATH);
        uuid = UUID.randomUUID().toString();
        tokenResponse = authTokenGenerator.retrieveNewToken(scopes, new HashMap<>());
        System.out.println(tokenResponse.getAccessToken());
        tokenHeader.put("Authorization", "Bearer" + " " + tokenResponse.getAccessToken());
    }

    @Test
    public void shouldPostOperationSuccessfullyToPeerUss() throws IOException {
        //given
        String str = ReadSampleOperationFromAFile("operationValidData.json");
        PutOperationDetailsParameters putOperationDetailsParameters = Utils.jsonToPojoGson(str, PutOperationDetailsParameters.class);
        putOperationDetailsParameters.setOperationId(uuid);
        String putOperationRequestStr = Utils.pojoToJson(putOperationDetailsParameters);

        //when
        HttpResponse httpResponse = httpClient.postEntity(tokenHeader, requestUrlParams, putOperationRequestStr);

        //then
        assertThat(httpResponse.getResponseCode(), is(204));
    }

    @Test
    public void shouldReturnA400whenTheOperationIsPostedWithIncorrectData() throws IOException {
        //given
        String str = ReadSampleOperationFromAFile("operationInvalidData.json");
        PutOperationDetailsParameters putOperationDetailsParameters = Utils.jsonToPojoGson(str, PutOperationDetailsParameters.class);
        String putOperationRequestStr = Utils.pojoToJson(putOperationDetailsParameters);

        //when
        HttpResponse httpResponse = httpClient.postEntity(tokenHeader, requestUrlParams, putOperationRequestStr);

        //then
        assertThat(httpResponse.getResponseCode(), is(400));
        ErrorResponseMessage errorResponseMessage = getErrorResponseMessage(httpResponse);
        assertNotNull(httpResponse.getResponseBody());
        assertNotNull(errorResponseMessage.getMessage());
    }

    @Test
    public void shouldReturn409WhenEntityVersionOfAMessageIsOlderThanPreviouslySentMessage() throws IOException {
        //Before
        String opId = UUID.randomUUID().toString();
        Integer version = 2;
        String str = ReadSampleOperationFromAFile("operationValidData.json");
        PutOperationDetailsParameters putOperationDetailsParameters = Utils.jsonToPojoGson(str, PutOperationDetailsParameters.class);
        putOperationDetailsParameters.setOperationId(opId);
        putOperationDetailsParameters.getOperation().getReference().setId(opId);
        putOperationDetailsParameters.getOperation().getReference().setVersion(version);
        String putOperationRequestStr = Utils.pojoToJson(putOperationDetailsParameters);

        HttpResponse httpResponse = httpClient.postEntity(tokenHeader, requestUrlParams, putOperationRequestStr);
        assertThat(httpResponse.getResponseCode(), is(204));

        //given
        putOperationDetailsParameters.getOperation().getReference().setVersion(version-1);
        putOperationRequestStr = Utils.pojoToJson(putOperationDetailsParameters);

        //when
        httpResponse = httpClient.postEntity(tokenHeader, requestUrlParams, putOperationRequestStr);

        //then
        assertThat(httpResponse.getResponseCode(), is(409));

    }

    @Test
    public void shouldReturnA401WhenTheRequestIsSentWithInvalidToken() throws IOException {
        //given
        String str = ReadSampleOperationFromAFile("operationValidData.json");
        PutOperationDetailsParameters putOperationDetailsParameters = Utils.jsonToPojoGson(str, PutOperationDetailsParameters.class);
        putOperationDetailsParameters.setOperationId(uuid);
        String putOperationRequestStr = Utils.pojoToJson(putOperationDetailsParameters);

        //when
        HttpResponse httpResponse = httpClient.postEntity(new HashMap<>(), requestUrlParams, putOperationRequestStr);

        //then
        assertThat(httpResponse.getResponseCode(), is(401));
    }

    @Test
    public void shouldReturnA403WhenTheScopeIsIncorrectToPostTheOperations() throws IOException {
        //given
        String str = ReadSampleOperationFromAFile("operationValidData.json");
        PutOperationDetailsParameters putOperationDetailsParameters = Utils.jsonToPojoGson(str, PutOperationDetailsParameters.class);
        putOperationDetailsParameters.setOperationId(uuid);
        String putOperationRequestStr = Utils.pojoToJson(putOperationDetailsParameters);

        //when
        HttpResponse httpResponse = httpClient.postEntity(getTokenHeaderWithIncorrectScope(), requestUrlParams, putOperationRequestStr);

        //then
        assertThat(httpResponse.getResponseCode(), is(403));
    }

    private String ReadSampleOperationFromAFile(String filename) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }

    private ErrorResponseMessage getErrorResponseMessage(HttpResponse httpResponse) {
        return Utils.jsonToPojoGson(httpResponse.getResponseBody(), ErrorResponseMessage.class);
    }

    // Adding incorrect scope; a PSU does not need constraints consumption scope for an operation
    private Map<String, String> getTokenHeaderWithIncorrectScope() throws IOException {
        List<String> scopes = Collections.singletonList("utm.constraint_consumption");
        TokenResponse tr = authTokenGenerator.retrieveNewToken(scopes, new HashMap<>());
        Map<String, String> th = new HashMap<>();
        th.put("Authorization", "Bearer" + " " + tr.getAccessToken());
        return th;
    }
}
