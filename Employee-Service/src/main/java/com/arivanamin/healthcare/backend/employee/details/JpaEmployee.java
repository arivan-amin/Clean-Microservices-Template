package com.arivanamin.healthcare.backend.employee.details;

import com.arivanamin.healthcare.backend.core.domain.gender.Gender;
import com.arivanamin.healthcare.backend.employee.core.entity.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
class JpaEmployee {
    
    private static ModelMapper mapper = new ModelMapper();
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    UUID id;
    
    @NotBlank
    String firstName;
    
    @NotBlank
    String lastName;
    
    @Email
    String email;
    
    @Past
    LocalDate dateOfBirth;
    
    @NotNull
    Gender gender;
    
    @NotBlank
    String address;
    
    public static JpaEmployee fromDomain (Employee employee) {
        return mapper.map(employee, JpaEmployee.class);
    }
    
    public Employee toDomain () {
        return mapper.map(this, Employee.class);
    }
}
