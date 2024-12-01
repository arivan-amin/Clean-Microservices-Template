package com.arivanamin.app.name.backend.employee.application.cli;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeePersistence;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.IntStream;

@Configuration
@RequiredArgsConstructor
class DemoDataInitializer {
    
    Faker faker = new Faker();
    
    @Bean
    CommandLineRunner initDatabase (EmployeePersistence persistence) {
        return args -> {
            if (persistence.findAll()
                .isEmpty()) {
                int numberOfEntities = faker.number()
                    .numberBetween(5, 15);
                populateEmployeeRepository(persistence, numberOfEntities);
            }
        };
    }
    
    private void populateEmployeeRepository (EmployeePersistence persistence,
                                             int numberOfEntities) {
        IntStream.rangeClosed(1, numberOfEntities)
            .mapToObj(this::createEmployee)
            .forEachOrdered(persistence::create);
    }
    
    private Employee createEmployee (long i) {
        Employee employee = new Employee();
        employee.setName(faker.elderScrolls()
            .firstName());
        return employee;
    }
}
