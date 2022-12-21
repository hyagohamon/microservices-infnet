package com.hamon.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GatewayApplication {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route(p -> p.path("/produtos/**").uri("http://localhost:8585"))
                .route(p -> p.path("/users/**").uri("http://localhost:9697"))
                .route(p -> p.path("/pedidos/**").filters(f -> f.circuitBreaker(
                        config -> config.setName("mycmd").setFallbackUri("forward:/fallback")
                )).uri("http://localhost:9697"))
                .build();

    }

    @GetMapping("/fallback")
    public String fallback() {
        return "Estamos em manutenção, volte mais tarde";
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
