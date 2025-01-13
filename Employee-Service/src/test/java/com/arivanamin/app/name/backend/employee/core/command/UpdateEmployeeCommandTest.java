package com.arivanamin.app.name.backend.employee.core.command;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import com.arivanamin.app.name.backend.testing.architecture.bases.BaseUnitTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class UpdateEmployeeCommandTest implements BaseUnitTest {
    
    private final Employee employee = RANDOM.nextObject(Employee.class);
    
    private EmployeeStorage persistence;
    private UpdateEmployeeCommand command;
    
    @Test
    void shouldCallPersistenceUpdate () {
        givenCommandWithMockPersistence();
        whenCommandIsExecuted();
        thenVerifyCommandCallsPersistenceUpdate();
    }
    
    private void givenCommandWithMockPersistence () {
        persistence = Mockito.mock(EmployeeStorage.class);
        command = new UpdateEmployeeCommand(persistence);
    }
    
    private void whenCommandIsExecuted () {
        command.execute(employee);
    }
    
    private void thenVerifyCommandCallsPersistenceUpdate () {
        verify(persistence, times(1)).update(any());
    }
    
    @Test
    void shouldPassParameterToPersistence () {
        givenCommandWithMockPersistence();
        whenCommandIsExecuted();
        thenAssertCommandPassesParameterToPersistence();
    }
    
    private void thenAssertCommandPassesParameterToPersistence () {
        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
        verify(persistence).update(captor.capture());
        Employee result = captor.getValue();
        Assertions.assertThat(result)
            .isSameAs(employee);
    }
}
