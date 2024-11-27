package com.arivanamin.app.name.backend.employee.application.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public final class EmployeeApiConfig {
    
    public static final String PROTECTED_API_BASE_PATH = "/employees/protected";
    public static final String PUBLIC_API_BASE_PATH = "/employees/public";
}
