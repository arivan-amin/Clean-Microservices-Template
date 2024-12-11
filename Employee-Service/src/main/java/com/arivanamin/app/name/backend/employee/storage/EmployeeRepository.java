package com.arivanamin.app.name.backend.employee.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<JpaEmployee, UUID> {
    
}
