package com.arivanamin.app.name.backend.employee.core.command;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateEmployeeCommand {
    
    private final EmployeeStorage persistence;
    
    public void execute (UUID id, Employee employee) {
        persistence.update(id, employee);
    }
}
