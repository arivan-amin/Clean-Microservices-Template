package com.arivanamin.app.name.backend.employee.application.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.arivanamin.app.name.backend.base.domain.config.CoreApplicationConfig.LIQUIBASE_CHANGELOG_PATH;

@Configuration
class PatientLiquibaseConfig {
    
    @Bean
    public SpringLiquibase liquibase () {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(LIQUIBASE_CHANGELOG_PATH);
        liquibase.setShouldRun(true);
        return liquibase;
    }
}
