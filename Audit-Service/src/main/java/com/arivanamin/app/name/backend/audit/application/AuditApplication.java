package com.arivanamin.app.name.backend.audit.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import static com.arivanamin.app.name.backend.base.domain.config.CoreApplicationConfig.BASE_PACKAGE;

@SpringBootApplication (scanBasePackages = BASE_PACKAGE)
@EntityScan (BASE_PACKAGE)
@EnableDiscoveryClient
@EnableCaching
public class AuditApplication {
    
    public static void main (String[] args) {
        SpringApplication.run(AuditApplication.class, args);
    }
}
