package com.uss.validationtests.auth.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

@Data
public class TokenResponse {
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_TOKEN_TYPE = "token_type";
    private static final String KEY_EXPIRES_IN = "expires_in";
    private static final String KEY_SCOPE = "scope";
    private static final String KEY_SUB = "sub";
    private static final String KEY_NBF = "nbf";
    private static final String KEY_ISS = "iss";
    private static final String KEY_JTI = "jti";
    private static final String REQUEST_ID = "request_id";

    @NotNull
    @JsonProperty(KEY_ACCESS_TOKEN)
    private String accessToken;

    @JsonProperty(KEY_TOKEN_TYPE)
    private String tokenType;

    @JsonProperty(KEY_EXPIRES_IN)
    private long expiresIn;

    @JsonProperty(KEY_SCOPE)
    private String scope;

    @JsonProperty(KEY_SUB)
    private String subject;

    @JsonProperty(KEY_NBF)
    private long notBefore;

    @JsonProperty(KEY_ISS)
    private String issuer;

    @JsonProperty(KEY_JTI)
    private UUID tokenId;

    @JsonProperty(REQUEST_ID)
    private String requestId;

    @Builder
    public TokenResponse(
        @NonNull @JsonProperty(KEY_ACCESS_TOKEN) String accessToken,
        @JsonProperty(KEY_TOKEN_TYPE) String tokenType,
        @JsonProperty(KEY_EXPIRES_IN) long expiresIn,
        @JsonProperty(KEY_SCOPE) String scope,
        @JsonProperty(KEY_SUB) String subject,
        @JsonProperty(KEY_NBF) long notBefore,
        @JsonProperty(KEY_ISS) String issuer,
        @JsonProperty(KEY_JTI) UUID tokenId) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.scope = scope;
        this.subject = subject;
        this.notBefore = notBefore == 0 ? Instant.now().getEpochSecond() : notBefore;
        this.issuer = issuer;
        this.tokenId = tokenId;
    }
}
