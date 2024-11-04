package com.arivanamin.healthcare.backend.employee.core.entity;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    UUID id;
    String name;
}
