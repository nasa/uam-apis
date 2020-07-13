package com.uss.validationtests.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ErrorResponseMessage {
    private String message;
}
