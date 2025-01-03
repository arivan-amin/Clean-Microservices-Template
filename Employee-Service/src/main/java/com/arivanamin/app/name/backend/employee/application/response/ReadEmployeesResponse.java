package com.arivanamin.app.name.backend.employee.application.response;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import lombok.Value;

import java.util.List;

@Value
public class ReadEmployeesResponse {
    
    List<EmployeeResponse> responses;
    
    public static ReadEmployeesResponse of (List<Employee> employees) {
        return new ReadEmployeesResponse(employees.stream()
            .map(EmployeeResponse::of)
            .toList());
    }
}
