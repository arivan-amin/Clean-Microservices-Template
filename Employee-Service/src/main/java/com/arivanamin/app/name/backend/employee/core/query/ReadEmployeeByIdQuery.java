package com.arivanamin.app.name.backend.employee.core.query;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.exception.EmployeeNotFoundException;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ReadEmployeeByIdQuery {
    
    private final EmployeeStorage storage;
    
    public Employee execute (UUID id) {
        return storage.findById(id)
            .orElseThrow(EmployeeNotFoundException::new);
    }
}
