package com.arivanamin.app.name.backend.employee.storage;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@RequiredArgsConstructor
@Slf4j
public class JpaEmployeeStorage implements EmployeeStorage {
    
    private final EmployeeRepository repository;
    
    @Override
    public List<Employee> findAll () {
        return repository.findAll()
            .stream()
            .map(JpaEmployee::toDomain)
            .toList();
    }
    
    @Override
    public Optional<Employee> findById (UUID id) {
        return repository.findById(id)
            .map(JpaEmployee::toDomain);
    }
    
    @Transactional
    @Override
    public UUID create (Employee employee) {
        return repository.save(JpaEmployee.fromDomain(employee))
            .getId();
    }
    
    @Transactional
    @Override
    public void update (Employee employee) {
        repository.save(JpaEmployee.fromDomain(employee));
    }
    
    @Transactional
    @Override
    public void delete (UUID id) {
        repository.deleteById(id);
    }
}
