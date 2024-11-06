package com.arivanamin.app.name.backend.employee.core.command;

import com.arivanamin.app.name.backend.employee.core.persistence.EmployeePersistence;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteEmployeeCommand {
    
    private final EmployeePersistence persistence;
    
    public void execute (UUID id) {
        persistence.delete(id);
    }
}
