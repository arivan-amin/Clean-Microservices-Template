package com.arivanamin.app.name.backend.employee.application.config;

import com.arivanamin.app.name.backend.employee.core.command.*;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import com.arivanamin.app.name.backend.employee.core.query.ReadEmployeeByIdQuery;
import com.arivanamin.app.name.backend.employee.core.query.ReadEmployeesQuery;
import com.arivanamin.app.name.backend.employee.storage.EmployeeRepository;
import com.arivanamin.app.name.backend.employee.storage.JpaEmployeeStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class CommandAndQueryBeansConfig {
    
    @Bean
    public EmployeeStorage storage (EmployeeRepository repository) {
        return new JpaEmployeeStorage(repository);
    }
    
    @Bean
    public ReadEmployeesQuery readEmployeesQuery (EmployeeStorage storage) {
        return new ReadEmployeesQuery(storage);
    }
    
    @Bean
    public ReadEmployeeByIdQuery readEmployeeByIdQuery (EmployeeStorage storage) {
        return new ReadEmployeeByIdQuery(storage);
    }
    
    @Bean
    public CreateEmployeeCommand createEmployeeCommand (EmployeeStorage storage) {
        return new CreateEmployeeCommand(storage);
    }
    
    @Bean
    public UpdateEmployeeCommand updateEmployeeCommand (EmployeeStorage storage) {
        return new UpdateEmployeeCommand(storage);
    }
    
    @Bean
    public DeleteEmployeeCommand deleteEmployeeCommand (EmployeeStorage storage) {
        return new DeleteEmployeeCommand(storage);
    }
}
