package com.arivanamin.app.name.backend.employee.application.endpoints;

import com.arivanamin.app.name.backend.employee.application.request.CreateEmployeeRequest;
import com.arivanamin.app.name.backend.employee.application.response.*;
import com.arivanamin.app.name.backend.employee.core.command.*;
import com.arivanamin.app.name.backend.employee.core.query.ReadEmployeeByIdQuery;
import com.arivanamin.app.name.backend.employee.core.query.ReadEmployeesQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.arivanamin.app.name.backend.employee.application.config.EmployeeApiConfig.PROTECTED_API_BASE_PATH;

@Tag (name = "Employee Controller")
@RestController
@RequiredArgsConstructor
@Slf4j
class EmployeeController {
    
    private final ReadEmployeesQuery readQuery;
    private final ReadEmployeeByIdQuery readByIdQuery;
    private final CreateEmployeeCommand createCommand;
    private final UpdateEmployeeCommand updateCommand;
    private final DeleteEmployeeCommand deleteCommand;
    
    @GetMapping (PROTECTED_API_BASE_PATH + "/v1/accounts")
    @Cacheable (cacheNames = "employeesCache")
    @Operation (summary = "Get a list of employees")
    @ResponseStatus (HttpStatus.OK)
    public ReadPatientsResponse getAllPatients () {
        return ReadPatientsResponse.of(readQuery.execute());
    }
    
    @GetMapping (PROTECTED_API_BASE_PATH + "/v1/accounts/{id}")
    @Cacheable (cacheNames = "employeeByIdCache")
    @Operation (summary = "Get a single employee by id")
    @ResponseStatus (HttpStatus.OK)
    public PatientResponse getPatientById (@PathVariable UUID id) {
        return PatientResponse.of(readByIdQuery.execute(id));
    }
    
    @PostMapping (PROTECTED_API_BASE_PATH + "/v1/accounts")
    @Operation (summary = "Creates an employee")
    @ResponseStatus (HttpStatus.CREATED)
    public CreatePatientResponse createPatient (@RequestBody @Valid CreateEmployeeRequest request) {
        UUID createdPatientId = createCommand.execute(request.toEntity());
        return CreatePatientResponse.of(createdPatientId);
    }
    
    @PutMapping (PROTECTED_API_BASE_PATH + "/v1/accounts/{id}")
    @Operation (summary = "Updates an employee")
    @ResponseStatus (HttpStatus.OK)
    public void updatePatient (@PathVariable UUID id,
        @RequestBody @Valid CreateEmployeeRequest request) {
        updateCommand.execute(id, request.toEntity());
    }
    
    @DeleteMapping (PROTECTED_API_BASE_PATH + "/v1/accounts/{id}")
    @Operation (summary = "Deletes an employee")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deletePatient (@PathVariable UUID id) {
        deleteCommand.execute(id);
    }
}
