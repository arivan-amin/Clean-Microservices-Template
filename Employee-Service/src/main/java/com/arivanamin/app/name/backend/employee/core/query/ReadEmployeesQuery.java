package com.arivanamin.app.name.backend.employee.core.query;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeePersistence;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReadEmployeesQuery {
    
    private final EmployeePersistence persistence;
    
    public List<Employee> execute () {
        return persistence.findAll();
    }
}
