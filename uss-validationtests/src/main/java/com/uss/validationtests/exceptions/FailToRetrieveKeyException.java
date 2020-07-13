package com.uss.validationtests.exceptions;

import java.security.GeneralSecurityException;

public class FailToRetrieveKeyException extends GeneralSecurityException {
    public FailToRetrieveKeyException() {
        super();
    }

    public FailToRetrieveKeyException(String msg) {
        super(msg);
    }

    public FailToRetrieveKeyException(Throwable cause) {
        super(cause);
    }

    public FailToRetrieveKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
