package com.arivanamin.healthcare.backend.api.gateway.infrastructure.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

import static java.lang.System.getenv;

@Configuration
public class ApiGatewayConfig {
    
    public static final String EUREKA_HOST = getenv().getOrDefault("EUREKA_HOST", "localhost");
    
    public static final String EUREKA_URL = "http://%s:8761".formatted(EUREKA_HOST);
    
    @Bean
    public RouteLocator routeLocator (RouteLocatorBuilder builder) {
        return builder.routes()
            .route(getDiscoveryServerRoute())
            .route(getDiscoveryServerStaticResourcesRoute())
            .route(getServiceRoute())
            .route(getServiceApiDocRoute())
            .route(getServiceActuatorRoute())
            .build();
    }
    
    private Function<PredicateSpec, Buildable<Route>> getDiscoveryServerRoute () {
        return r -> r.path("/eureka/web").filters(f -> f.setPath("/")).uri(EUREKA_URL);
    }
    
    private Function<PredicateSpec, Buildable<Route>> getDiscoveryServerStaticResourcesRoute () {
        return r -> r.path("/eureka/**").uri(EUREKA_URL);
    }
    
    private Function<PredicateSpec, Buildable<Route>> getServiceRoute () {
        return r -> r.path("/[service-name]s/**").uri("lb://[service-name]-service");
    }
    
    private Function<PredicateSpec, Buildable<Route>> getServiceApiDocRoute () {
        return r -> r.path("/[service-name]-service/api-docs")
            .filters(f -> f.setPath("/v3/api-docs"))
            .uri("lb://[service-name]-service");
    }
    
    private Function<PredicateSpec, Buildable<Route>> getServiceActuatorRoute () {
        return r -> r.path("/actuator/[service-name]s/**")
            .filters(f -> f.rewritePath("/actuator/[service-name]s/(?<segment>.*)",
                "/actuator/${segment}"))
            .uri("lb://[service-name]-service");
    }
}
