package com.uss.validationtests.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class HttpResponse {
    private int responseCode;
    private String responseBody;
    private String reason;
}
