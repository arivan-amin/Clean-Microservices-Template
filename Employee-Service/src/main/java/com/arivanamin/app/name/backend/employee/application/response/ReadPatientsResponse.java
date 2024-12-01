package com.arivanamin.app.name.backend.employee.application.response;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import lombok.Value;

import java.util.List;

@Value
public class ReadPatientsResponse {
    
    List<PatientResponse> responses;
    
    public static ReadPatientsResponse of (List<Employee> employees) {
        return new ReadPatientsResponse(employees.stream()
            .map(PatientResponse::of)
            .toList());
    }
}
