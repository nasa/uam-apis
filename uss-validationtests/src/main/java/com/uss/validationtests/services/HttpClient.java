package com.uss.validationtests.services;

import com.uss.validationtests.models.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* This is apache http client*/
@Component
public class HttpClient {
    @Autowired
    private PropertiesConfig propertiesConfig;
    private final String hostname;

    public HttpClient(PropertiesConfig propertiesConfig) {
        this.propertiesConfig = propertiesConfig;
        this.hostname = propertiesConfig.getUssHostName();
    }

    public HttpResponse getEntity(Map<String, String> headers, List<String> params) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (String p : params) {
            sb.append("/").append(p);
        }
        HttpGet request = new HttpGet(hostname.concat(sb.toString()));
        for (Map.Entry<String, String> header : headers.entrySet()) {
            request.addHeader(header.getKey(), header.getValue());
        }
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            return HttpResponse.builder()
                .responseBody(response.getEntity() != null ? EntityUtils.toString(response.getEntity()) : null)
                .responseCode(response.getStatusLine().getStatusCode())
                .reason(response.getStatusLine().getReasonPhrase())
                .build();
        }
    }

    public HttpResponse postEntity(Map<String, String> headers, List<String> params, String body) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (String p : params) {
            sb.append("/").append(p);
        }
        HttpPost post = new HttpPost(hostname.concat(sb.toString()));
        for (Map.Entry<String, String> header : headers.entrySet()) {
            post.addHeader(header.getKey(), header.getValue());
        }
        post.addHeader("Content-Type", "application/json");
        post.setEntity(new StringEntity(body));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {
            return HttpResponse.builder()
                .responseBody(response.getEntity() != null ? EntityUtils.toString(response.getEntity()) : null)
                .responseCode(response.getStatusLine().getStatusCode())
                .reason(response.getStatusLine().getReasonPhrase())
                .build();
        }
    }
}
