package com.uss.validationtests.auth;

import com.uss.validationtests.services.PropertiesConfig;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class WellKnownUrlResolver {
    private static final String USS_PATH = "/.well-known/uas-traffic-management/";

    @Autowired
    private final PropertiesConfig propertiesConfig;

    @Getter
    private final URI baseUri;

    public WellKnownUrlResolver(PropertiesConfig propertiesConfig) {
        this.propertiesConfig = propertiesConfig;
        this.baseUri = URI.create(this.propertiesConfig.getUssHostName()).resolve(USS_PATH);
    }

    public URI resolve(String fileName) {
        return this.baseUri.resolve(fileName);
    }
}
