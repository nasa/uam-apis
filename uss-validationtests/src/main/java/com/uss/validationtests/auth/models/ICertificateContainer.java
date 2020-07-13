package com.uss.validationtests.auth.models;

import java.net.URI;
import java.security.cert.Certificate;

public interface ICertificateContainer {
    String getKid();

    URI getUri();

    Certificate getCertificate();

    String getThumbprint();

    boolean isForeign();
}
