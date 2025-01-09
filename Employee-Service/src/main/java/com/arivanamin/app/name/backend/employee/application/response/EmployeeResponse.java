package com.arivanamin.app.name.backend.employee.application.response;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    
    UUID id;
    String name;
    String address;
    LocalDate dateOfBirth;
    
    public static EmployeeResponse of (Employee employee) {
        return new ModelMapper().map(employee, EmployeeResponse.class);
    }
}
