package com.arivanamin.app.name.backend.employee.core.command;

import com.arivanamin.app.name.backend.employee.application.request.CreateEmployeeRequest;
import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeePersistence;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CreateEmployeeCommand {
    
    private final EmployeePersistence persistence;
    
    public UUID execute (CreateEmployeeRequest request) {
        Employee employee = request.toEntity();
        return persistence.create(employee);
    }
}
