package com.arivanamin.app.name.backend.employee.core.query;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReadEmployeesQuery {
    
    private final EmployeeStorage storage;
    
    public List<Employee> execute () {
        return storage.findAll();
    }
}
