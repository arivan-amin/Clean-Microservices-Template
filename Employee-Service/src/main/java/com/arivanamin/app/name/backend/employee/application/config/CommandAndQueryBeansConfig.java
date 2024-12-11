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
    public ReadEmployeesQuery readPatientsQuery (EmployeeStorage persistence) {
        return new ReadEmployeesQuery(persistence);
    }
    
    @Bean
    public ReadEmployeeByIdQuery readPatientByIdQuery (EmployeeStorage persistence) {
        return new ReadEmployeeByIdQuery(persistence);
    }
    
    @Bean
    public CreateEmployeeCommand createPatientCommand (EmployeeStorage persistence) {
        return new CreateEmployeeCommand(persistence);
    }
    
    @Bean
    public UpdateEmployeeCommand updatePatientCommand (EmployeeStorage persistence) {
        return new UpdateEmployeeCommand(persistence);
    }
    
    @Bean
    public DeleteEmployeeCommand deletePatientCommand (EmployeeStorage persistence) {
        return new DeleteEmployeeCommand(persistence);
    }
}
