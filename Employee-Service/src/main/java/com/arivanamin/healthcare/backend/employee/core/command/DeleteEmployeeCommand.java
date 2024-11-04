package com.arivanamin.healthcare.backend.employee.core.command;

import com.arivanamin.healthcare.backend.employee.core.persistence.EmployeePersistence;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteEmployeeCommand {
    
    private final EmployeePersistence persistence;
    
    public void execute (UUID id) {
        persistence.delete(id);
    }
}
