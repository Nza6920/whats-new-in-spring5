package com.niu.client;

import org.springframework.web.reactive.function.client.WebClient;

public class WebClientCaller {

    public static void main(String[] args) {
        WebClient webClient = WebClient.create();
        WebClient.RequestHeadersUriSpec<?> requestHeadersUriSpec = webClient.get();
    }
}
