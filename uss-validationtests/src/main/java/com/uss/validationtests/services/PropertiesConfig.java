package com.uss.validationtests.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesConfig {

    private String ussHostName;

    private String fimsAuthzUrl;

    private String clientId;

    public PropertiesConfig(@Value("${uss.host.name}") String ussHostName, @Value("${fims.authz.url}") String fimsAuthzUrl, @Value("${client.id}") String clientId) {
        this.ussHostName = ussHostName;
        this.clientId = clientId;
        this.fimsAuthzUrl = fimsAuthzUrl;
    }

    public String getUssHostName() {
        return this.ussHostName;
    }

    public String getFimsAuthzUrl() {
        return this.fimsAuthzUrl;
    }

    public String getClientId() {
        return this.clientId;
    }
}
