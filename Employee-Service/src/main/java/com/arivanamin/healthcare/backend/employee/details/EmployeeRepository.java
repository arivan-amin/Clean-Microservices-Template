package com.arivanamin.healthcare.backend.employee.details;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<JpaEmployee, UUID> {
    
}
