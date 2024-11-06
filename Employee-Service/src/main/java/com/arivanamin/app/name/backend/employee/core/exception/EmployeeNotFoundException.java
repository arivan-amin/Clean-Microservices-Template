package com.arivanamin.app.name.backend.employee.core.exception;

public class EmployeeNotFoundException extends RuntimeException {
    
    public EmployeeNotFoundException () {
        super("Employee by the requested id not found");
    }
}
