package com.arivanamin.app.name.backend.employee.application.endpoints;

import com.arivanamin.app.name.backend.employee.application.request.CreateEmployeeRequest;
import com.arivanamin.app.name.backend.employee.application.request.UpdateEmployeeRequest;
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

import static com.arivanamin.app.name.backend.employee.application.config.EmployeeApiURLs.*;

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
    
    @GetMapping (GET_EMPLOYEES_URL)
    @Cacheable (cacheNames = "employeesCache")
    @Operation (summary = "Get a list of employees")
    @ResponseStatus (HttpStatus.OK)
    public ReadEmployeesResponse getAllEmployees () {
        return ReadEmployeesResponse.of(readQuery.execute());
    }
    
    @GetMapping (GET_EMPLOYEE_BY_ID_URL)
    @Cacheable (cacheNames = "employeeByIdCache")
    @Operation (summary = "Get a single employee by id")
    @ResponseStatus (HttpStatus.OK)
    public EmployeeResponse getEmployeeById (@PathVariable UUID id) {
        return EmployeeResponse.of(readByIdQuery.execute(id));
    }
    
    @PostMapping (CREATE_EMPLOYEE_URL)
    @Operation (summary = "Creates an employee")
    @ResponseStatus (HttpStatus.CREATED)
    public CreateEmployeeResponse createEmployee (
        @RequestBody @Valid CreateEmployeeRequest request) {
        UUID createdEmployeeId = createCommand.execute(request.toEntity());
        return CreateEmployeeResponse.of(createdEmployeeId);
    }
    
    @PutMapping (UPDATE_EMPLOYEE_URL)
    @Operation (summary = "Updates an employee")
    @ResponseStatus (HttpStatus.OK)
    public void updateEmployee (@PathVariable UUID id,
                                @RequestBody @Valid UpdateEmployeeRequest request) {
        updateCommand.execute(request.toEntity(id));
    }
    
    @DeleteMapping (DELETE_EMPLOYEE_URL)
    @Operation (summary = "Deletes an employee")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deleteEmployee (@PathVariable UUID id) {
        deleteCommand.execute(id);
    }
}
