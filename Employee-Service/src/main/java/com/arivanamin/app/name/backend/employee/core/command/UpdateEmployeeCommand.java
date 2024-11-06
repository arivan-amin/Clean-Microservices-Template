package com.arivanamin.app.name.backend.employee.core.command;

import com.arivanamin.app.name.backend.employee.application.request.CreateEmployeeRequest;
import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeePersistence;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateEmployeeCommand {
    
    private final EmployeePersistence persistence;
    
    public void execute (UUID id, CreateEmployeeRequest request) {
        Employee employee = request.toEntity();
        persistence.update(id, employee);
    }
}
