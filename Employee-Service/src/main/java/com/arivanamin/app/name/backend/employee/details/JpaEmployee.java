package com.arivanamin.app.name.backend.employee.details;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.modelmapper.ModelMapper;

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
    String name;
    
    public static JpaEmployee fromDomain (Employee employee) {
        return mapper.map(employee, JpaEmployee.class);
    }
    
    public Employee toDomain () {
        return mapper.map(this, Employee.class);
    }
}
