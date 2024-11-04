package com.arivanamin.healthcare.backend.employee.core.command;

import com.arivanamin.healthcare.backend.employee.application.request.CreateEmployeeRequest;
import com.arivanamin.healthcare.backend.employee.core.entity.Employee;
import com.arivanamin.healthcare.backend.employee.core.persistence.EmployeePersistence;
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
