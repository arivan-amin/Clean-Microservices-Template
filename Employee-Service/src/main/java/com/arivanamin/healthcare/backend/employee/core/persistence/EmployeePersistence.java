package com.arivanamin.healthcare.backend.employee.core.persistence;

import com.arivanamin.healthcare.backend.employee.core.entity.Employee;

import java.util.*;

public interface EmployeePersistence {
    
    List<Employee> findAll ();
    
    Optional<Employee> findById (UUID id);
    
    UUID create (Employee employee);
    
    void update (UUID id, Employee employee);
    
    void delete (UUID id);
}
