package com.arivanamin.app.name.backend.employee.core.command;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateEmployeeCommand {
    
    private final EmployeeStorage storage;
    
    public void execute (Employee employee) {
        storage.update(employee);
    }
}
