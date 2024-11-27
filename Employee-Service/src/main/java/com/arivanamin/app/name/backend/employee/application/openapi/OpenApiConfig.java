package com.arivanamin.app.name.backend.employee.application.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.arivanamin.app.name.backend.base.application.openapi.OpenApiDetails.*;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI myOpenAPI () {
        Server server = new Server();
        server.setUrl("localhost:8080/");
        server.setDescription("Server URL");
        
        Info info = new Info().title("Employee Service API")
            .description("Provides all the API related to Employee service")
            .version("1.0")
            .contact(getOpenApiContactDetails())
            .termsOfService(getOpenApiTermsOfService())
            .license(getOpenApiLicence());
        
        return new OpenAPI().info(info).servers(List.of(server));
    }
}
