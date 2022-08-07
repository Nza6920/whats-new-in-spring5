package com.niu.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;

public class ApiCaller {

    public static void main(String[] args) {
        String baseUrl = "http://localhost:8080";
        String apiPath = "/api/v2/price/{symbol}";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl);

        HashMap<String, Object> variables = new HashMap<>();
        variables.put("symbol", "1");
        URI uri = builder.path(apiPath)
                .uriVariables(variables)
                .build().encode().toUri();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> forEntity = restTemplate.getForEntity(uri, Object.class);
    }
}
