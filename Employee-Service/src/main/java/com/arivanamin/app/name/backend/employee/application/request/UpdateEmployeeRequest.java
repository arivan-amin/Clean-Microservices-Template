package com.arivanamin.app.name.backend.employee.application.request;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import lombok.Value;
import org.modelmapper.ModelMapper;

import java.util.UUID;

import static com.arivanamin.app.name.backend.base.domain.dates.TimestampHelper.toLocalDateTime;

@Value
public class UpdateEmployeeRequest {
    
    String name;
    long dateOfBirth;
    
    public Employee toEntity (UUID id) {
        Employee employee = new ModelMapper().map(this, Employee.class);
        employee.setId(id);
        employee.setDateOfBirth(toLocalDateTime(dateOfBirth).toLocalDate());
        return employee;
    }
}
