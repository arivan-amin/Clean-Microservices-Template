package com.arivanamin.app.name.backend.employee.application.response;

import lombok.Value;

import java.util.UUID;

@Value
public class CreateEmployeeResponse {
    
    UUID id;
    
    public static CreateEmployeeResponse of (UUID id) {
        return new CreateEmployeeResponse(id);
    }
}
