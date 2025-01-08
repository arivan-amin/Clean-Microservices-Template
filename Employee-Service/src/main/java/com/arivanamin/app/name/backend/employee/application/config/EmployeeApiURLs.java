package com.arivanamin.app.name.backend.employee.application.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public final class EmployeeApiURLs {
    
    public static final String PROTECTED_API = "/employees/protected";
    public static final String PUBLIC_API = "/employees/public";
    
    public static final String GET_EMPLOYEES_URL = PROTECTED_API + "/v1/accounts";
    public static final String GET_EMPLOYEE_BY_ID_URL = PROTECTED_API + "/v1/accounts/{id}";
    public static final String CREATE_EMPLOYEE_URL = PROTECTED_API + "/v1/accounts";
    public static final String UPDATE_EMPLOYEE_URL = PROTECTED_API + "/v1/accounts/{id}";
    public static final String DELETE_EMPLOYEE_URL = PROTECTED_API + "/v1/accounts/{id}";
}
