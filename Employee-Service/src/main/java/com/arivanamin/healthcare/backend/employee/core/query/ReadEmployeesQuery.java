package com.arivanamin.healthcare.backend.employee.core.query;

import com.arivanamin.healthcare.backend.employee.core.entity.Employee;
import com.arivanamin.healthcare.backend.employee.core.persistence.EmployeePersistence;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReadEmployeesQuery {
    
    private final EmployeePersistence persistence;
    
    public List<Employee> execute () {
        return persistence.findAll();
    }
}
