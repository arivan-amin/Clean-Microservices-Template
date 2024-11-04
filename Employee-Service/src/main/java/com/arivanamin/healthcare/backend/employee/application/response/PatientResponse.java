package com.arivanamin.healthcare.backend.employee.application.response;

import com.arivanamin.healthcare.backend.employee.core.entity.Employee;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse {
    
    UUID id;
    String name;
    
    public static PatientResponse of (Employee employee) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(employee, PatientResponse.class);
    }
}
