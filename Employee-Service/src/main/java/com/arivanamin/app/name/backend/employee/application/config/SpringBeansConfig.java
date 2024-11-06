package com.arivanamin.app.name.backend.employee.application.config;

import com.arivanamin.app.name.backend.employee.core.command.*;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeePersistence;
import com.arivanamin.app.name.backend.employee.core.query.ReadEmployeeByIdQuery;
import com.arivanamin.app.name.backend.employee.core.query.ReadEmployeesQuery;
import com.arivanamin.app.name.backend.employee.details.EmployeeRepository;
import com.arivanamin.app.name.backend.employee.details.JpaEmployeePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBeansConfig {
    
    @Bean
    public EmployeePersistence persistence (EmployeeRepository repository) {
        return new JpaEmployeePersistence(repository);
    }
    
    @Bean
    public ReadEmployeesQuery readPatientsQuery (EmployeePersistence persistence) {
        return new ReadEmployeesQuery(persistence);
    }
    
    @Bean
    public ReadEmployeeByIdQuery readPatientByIdQuery (EmployeePersistence persistence) {
        return new ReadEmployeeByIdQuery(persistence);
    }
    
    @Bean
    public CreateEmployeeCommand createPatientCommand (EmployeePersistence persistence) {
        return new CreateEmployeeCommand(persistence);
    }
    
    @Bean
    public UpdateEmployeeCommand updatePatientCommand (EmployeePersistence persistence) {
        return new UpdateEmployeeCommand(persistence);
    }
    
    @Bean
    public DeleteEmployeeCommand deletePatientCommand (EmployeePersistence persistence) {
        return new DeleteEmployeeCommand(persistence);
    }
}
