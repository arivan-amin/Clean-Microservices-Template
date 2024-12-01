package com.arivanamin.app.name.backend.employee.details;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.exception.EmployeeNotFoundException;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeePersistence;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import java.util.*;

@RequiredArgsConstructor
@Slf4j
@Transactional
public class JpaEmployeePersistence implements EmployeePersistence {
    
    private final EmployeeRepository repository;
    
    ModelMapper modelMapper = new ModelMapper();
    
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
    
    @Override
    public UUID create (Employee employee) {
        return repository.save(JpaEmployee.fromDomain(employee))
            .getId();
    }
    
    @Override
    public void update (UUID id, Employee employeeEntity) {
        JpaEmployee jpaEmployee = repository.findById(id)
            .orElseThrow(EmployeeNotFoundException::new);
        modelMapper.map(employeeEntity, jpaEmployee);
        repository.save(jpaEmployee);
    }
    
    @Override
    public void delete (UUID id) {
        repository.deleteById(id);
    }
}
