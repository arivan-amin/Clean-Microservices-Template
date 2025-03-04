package com.arivanamin.app.name.backend.employee.application.request;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import lombok.*;
import org.modelmapper.ModelMapper;

import static com.arivanamin.app.name.backend.base.domain.dates.TimestampHelper.toLocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {
    
    String name;
    String address;
    long dateOfBirth;
    
    public Employee toEntity () {
        Employee employee = new ModelMapper().map(this, Employee.class);
        employee.setDateOfBirth(toLocalDateTime(dateOfBirth).toLocalDate());
        return employee;
    }
}
