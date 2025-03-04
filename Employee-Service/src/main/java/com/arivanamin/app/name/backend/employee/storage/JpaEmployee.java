package com.arivanamin.app.name.backend.employee.storage;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table (name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
class JpaEmployee {
    
    @Id
    @UuidGenerator
    UUID id;
    
    @NotBlank
    String name;
    
    @NotBlank
    String address;
    
    @Past
    LocalDate dateOfBirth;
    
    public static JpaEmployee fromDomain (Employee employee) {
        return new ModelMapper().map(employee, JpaEmployee.class);
    }
    
    public Employee toDomain () {
        return new ModelMapper().map(this, Employee.class);
    }
}
