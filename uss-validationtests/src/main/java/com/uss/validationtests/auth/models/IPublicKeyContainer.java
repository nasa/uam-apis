package com.uss.validationtests.auth.models;

import java.security.PublicKey;

public interface IPublicKeyContainer {
    String getKid();

    PublicKey getPublicKey();

    boolean isForeign();
}
