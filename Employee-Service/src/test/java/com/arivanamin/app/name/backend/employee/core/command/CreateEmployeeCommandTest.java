package com.arivanamin.app.name.backend.employee.core.command;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import com.arivanamin.app.name.backend.testing.architecture.bases.BaseUnitTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CreateEmployeeCommandTest implements BaseUnitTest {
    
    private final String employeeName = FAKER.funnyName()
        .name();
    private final UUID createdEmployeeId = UUID.randomUUID();
    
    private EmployeeStorage persistence;
    private CreateEmployeeCommand command;
    
    private Employee employee;
    
    private void givenCommandWithMockFindAll () {
        persistence = mock(EmployeeStorage.class);
        command = new CreateEmployeeCommand(persistence);
        Employee employee = RANDOM.nextObject(Employee.class);
        employee.setName(employeeName);
        when(persistence.findAll()).thenReturn(List.of(employee));
    }
    
    @Test
    void shouldCallPersistenceCreate () {
        givenCommandWithMockPersistence();
        whenCommandIsExecuted();
        thenVerifyCommandCallsCreate();
    }
    
    private void givenCommandWithMockPersistence () {
        persistence = mock(EmployeeStorage.class);
        command = new CreateEmployeeCommand(persistence);
        when(persistence.create(any())).thenReturn(createdEmployeeId);
        employee = RANDOM.nextObject(Employee.class);
    }
    
    private UUID whenCommandIsExecuted () {
        return command.execute(employee);
    }
    
    private void thenVerifyCommandCallsCreate () {
        verify(persistence, times(1)).create(employee);
    }
    
    @Test
    void shouldReturnResultOfPersistenceCreate () {
        givenCommandWithMockPersistence();
        UUID resultId = whenCommandIsExecuted();
        thenVerifyCreateResultIsReturned(resultId);
    }
    
    private void thenVerifyCreateResultIsReturned (UUID resultId) {
        assertThat(resultId).isSameAs(createdEmployeeId);
    }
}
