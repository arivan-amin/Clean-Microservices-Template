package com.arivanamin.app.name.backend.employee.core.command;

import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteEmployeeCommand {
    
    private final EmployeeStorage storage;
    
    public void execute (UUID id) {
        storage.delete(id);
    }
}
