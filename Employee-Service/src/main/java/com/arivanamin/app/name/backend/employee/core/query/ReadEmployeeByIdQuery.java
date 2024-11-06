package com.arivanamin.app.name.backend.employee.core.query;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.exception.EmployeeNotFoundException;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeePersistence;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ReadEmployeeByIdQuery {
    
    private final EmployeePersistence persistence;
    
    public Employee execute (UUID id) {
        return persistence.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }
}
