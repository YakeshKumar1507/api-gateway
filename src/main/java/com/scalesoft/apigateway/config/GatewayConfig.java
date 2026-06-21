package com.scalesoft.apigateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Value("${hello.service.url}")
    private String helloServiceUrl;

    @Value("${greet.service.url}")
    private String greetServiceUrl;

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("hello-service",
                        r -> r.path("/hello/**")
                                .uri(helloServiceUrl))
                .route("greet-service",
                        r -> r.path("/greet/**")
                                .uri(greetServiceUrl))
                .build();
    }
}
