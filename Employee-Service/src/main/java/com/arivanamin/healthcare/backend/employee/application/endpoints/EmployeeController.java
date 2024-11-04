package com.arivanamin.healthcare.backend.employee.application.endpoints;

import com.arivanamin.healthcare.backend.employee.application.request.CreateEmployeeRequest;
import com.arivanamin.healthcare.backend.employee.application.response.*;
import com.arivanamin.healthcare.backend.employee.core.command.*;
import com.arivanamin.healthcare.backend.employee.core.query.ReadEmployeeByIdQuery;
import com.arivanamin.healthcare.backend.employee.core.query.ReadEmployeesQuery;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.arivanamin.healthcare.backend.employee.application.config.ApiConfig.API_BASE_PATH;

@RestController
@RequestMapping (API_BASE_PATH)
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    
    private final ReadEmployeesQuery readQuery;
    private final ReadEmployeeByIdQuery readByIdQuery;
    private final CreateEmployeeCommand createCommand;
    private final UpdateEmployeeCommand updateCommand;
    private final DeleteEmployeeCommand deleteCommand;
    
    @Cacheable (cacheNames = "employeesCache")
    @GetMapping ("/v1/accounts")
    @Operation (summary = "Get a list of employees")
    @ResponseStatus (HttpStatus.OK)
    public ReadPatientsResponse getAllPatients () {
        return ReadPatientsResponse.of(readQuery.execute());
    }
    
    @Cacheable (cacheNames = "employeeByIdCache")
    @GetMapping ("/v1/accounts/{id}")
    @Operation (summary = "Get a single employee by id")
    @ResponseStatus (HttpStatus.OK)
    public PatientResponse getPatientById (@PathVariable UUID id) {
        return PatientResponse.of(readByIdQuery.execute(id));
    }
    
    @PostMapping ("/v1/accounts")
    @Operation (summary = "Creates an employee")
    @ResponseStatus (HttpStatus.CREATED)
    public CreatePatientResponse createPatient (@RequestBody CreateEmployeeRequest request) {
        UUID createdPatientId = createCommand.execute(request);
        return CreatePatientResponse.of(createdPatientId);
    }
    
    @PutMapping ("/v1/accounts/{id}")
    @Operation (summary = "Updates an employee")
    @ResponseStatus (HttpStatus.OK)
    public void updatePatient (@PathVariable UUID id, @RequestBody CreateEmployeeRequest request) {
        updateCommand.execute(id, request);
    }
    
    @DeleteMapping ("/v1/accounts/{id}")
    @Operation (summary = "Deletes an employee")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deletePatient (@PathVariable UUID id) {
        deleteCommand.execute(id);
    }
}
