package com.arivanamin.app.name.backend.employee.core.command;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CreateEmployeeCommand {
    
    private final EmployeeStorage persistence;
    
    public UUID execute (Employee employee) {
        return persistence.create(employee);
    }
}
