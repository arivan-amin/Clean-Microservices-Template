package com.arivanamin.app.name.backend.employee.core.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    UUID id;
    String name;
    String address;
    LocalDate dateOfBirth;
}
