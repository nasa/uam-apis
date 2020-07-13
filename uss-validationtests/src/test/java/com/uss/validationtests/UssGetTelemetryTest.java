package com.uss.validationtests;

import com.uss.validationtests.auth.AuthTokenGenerator;
import com.uss.validationtests.auth.models.TokenResponse;
import com.uss.validationtests.models.ErrorResponseMessage;
import com.uss.validationtests.models.HttpResponse;
import com.uss.validationtests.services.HttpClient;
import com.uss.validationtests.swagger.GetOperationDetailsResponse;
import com.uss.validationtests.utils.Utils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
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
@TestPropertySource(properties = {
    "uss.operation.id=b53494b1-9608-4771-8c9e-cf15d2fdd98e",
})
public class UssGetTelemetryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UssGetTelemetryTest.class);
    private static final String USS_OPERATIONS_PATH = "uss/v1/operations";
    private static final String TELEMETRY = "telemetry";
    List<String> scopes = Arrays.asList("utm.strategic_coordination", "utm.constraint_consumption");

    //Make sure this field has the correct operation id that is submitted to the DSS by a USS
    @Value("${uss.operation.id}")
    private String ussOperationId;

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private AuthTokenGenerator authTokenGenerator;

    private TokenResponse tokenResponse;
    private Map<String, String> tokenHeader = new HashMap<>();
    private List<String> requestUrlParams = new ArrayList<>();

    @Before
    public void setup() throws IOException {
        requestUrlParams.add(USS_OPERATIONS_PATH);
        tokenResponse = authTokenGenerator.retrieveNewToken(scopes, new HashMap<>());
        System.out.println(tokenResponse.getAccessToken());
        tokenHeader.put("Authorization", "Bearer" + " " + tokenResponse.getAccessToken());
    }

    @Test
    public void shouldGetTelemetryDetailsSuccessfullyFromAUss() throws IOException {
        //given
        //TODO: Make sure this is the operation id that is submitted to the DSS by a PSU
        // and the operation is in the right state to send telemetry
        String operationId = ussOperationId;
        requestUrlParams.add(operationId);
        requestUrlParams.add(TELEMETRY);

        //when
        HttpResponse httpResponse = httpClient.getEntity(tokenHeader, requestUrlParams);

        //then
        assertThat(httpResponse.getResponseCode(), is(200));

        GetOperationDetailsResponse getOperationDetailsResponse = Utils.jsonToPojoGson(httpResponse.getResponseBody(), GetOperationDetailsResponse.class);
        assertNotNull(getOperationDetailsResponse.getOperation());
        assertNotNull(getOperationDetailsResponse.getOperation().getReference());
        assertNotNull(getOperationDetailsResponse.getOperation().getReference().getOvn());
        assertNotNull(getOperationDetailsResponse.getOperation().getReference().getUssBaseUrl());
        assertNotNull(getOperationDetailsResponse.getOperation().getDetails().getState());
        assertNotNull(getOperationDetailsResponse.getOperation().getDetails());
    }

    @Test
    public void shouldReturnA400whenTheTelemetryIsRequestedWithIncorrectData() throws IOException {
        //given
        String operationId = "anIncorrectOperationId";
        requestUrlParams.add(operationId);
        requestUrlParams.add(TELEMETRY);

        //when
        HttpResponse httpResponse = httpClient.getEntity(tokenHeader, requestUrlParams);

        //then
        assertThat(httpResponse.getResponseCode(), is(400));
        ErrorResponseMessage errorResponseMessage = getErrorResponseMessage(httpResponse);
        assertNotNull(httpResponse.getResponseBody());
        assertNotNull(errorResponseMessage.getMessage());
    }

    @Test
    public void shouldReturnA401WhenTheRequestIsSentWithInvalidToken() throws IOException {
        String operationId = ussOperationId;
        requestUrlParams.add(operationId);
        requestUrlParams.add(TELEMETRY);

        //when
        HttpResponse httpResponse = httpClient.getEntity(new HashMap<>(), requestUrlParams);

        //then
        assertThat(httpResponse.getResponseCode(), is(401));
        ErrorResponseMessage errorResponseMessage = getErrorResponseMessage(httpResponse);
        assertNotNull(httpResponse.getResponseBody());
        assertNotNull(errorResponseMessage.getMessage());
    }

    @Test
    public void shouldReturnA403WhenTheScopeIsIncorrectToGetTelemetry() throws IOException {
        //given
        String operationId = ussOperationId;
        requestUrlParams.add(operationId);
        requestUrlParams.add(TELEMETRY);

        //when
        HttpResponse httpResponse = httpClient.getEntity(getTokenHeaderWithIncorrectScope(), requestUrlParams);

        //then
        assertThat(httpResponse.getResponseCode(), is(403));
        ErrorResponseMessage errorResponseMessage = getErrorResponseMessage(httpResponse);
        assertNotNull(httpResponse.getResponseBody());
        assertNotNull(errorResponseMessage.getMessage());
    }

    @Test
    public void shouldReturnA404WhenTheTelemetryIsNotPresentWithTheUssForTheOperationId() throws IOException {
        //given
        String operationId = UUID.randomUUID().toString();
        requestUrlParams.add(operationId);
        requestUrlParams.add(TELEMETRY);

        //when
        HttpResponse httpResponse = httpClient.getEntity(tokenHeader, requestUrlParams);

        //then
        assertThat(httpResponse.getResponseCode(), is(404));
        ErrorResponseMessage errorResponseMessage = getErrorResponseMessage(httpResponse);
        assertNotNull(httpResponse.getResponseBody());
        assertNotNull(errorResponseMessage.getMessage());
    }

    @Test
    public void shouldReturnA409WhenTheOperationIsNotInTheRightStateToSendTelemetry() throws IOException {
        //given
        String operationId = ussOperationId;
        requestUrlParams.add(operationId);
        requestUrlParams.add(TELEMETRY);

        //when
        HttpResponse httpResponse = httpClient.getEntity(tokenHeader, requestUrlParams);

        //then
        assertThat(httpResponse.getResponseCode(), is(409));
        ErrorResponseMessage errorResponseMessage = getErrorResponseMessage(httpResponse);
        assertNotNull(httpResponse.getResponseBody());
        assertNotNull(errorResponseMessage.getMessage());
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
