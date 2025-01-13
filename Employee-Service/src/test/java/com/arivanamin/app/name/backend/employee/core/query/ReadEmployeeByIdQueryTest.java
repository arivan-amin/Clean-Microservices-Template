package com.arivanamin.app.name.backend.employee.core.query;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.exception.EmployeeNotFoundException;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import com.arivanamin.app.name.backend.testing.architecture.bases.BaseUnitTest;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ReadEmployeeByIdQueryTest implements BaseUnitTest {
    
    private final Employee employee = RANDOM.nextObject(Employee.class);
    private final UUID id = UUID.randomUUID();
    
    private EmployeeStorage persistence;
    private ReadEmployeeByIdQuery query;
    
    @Test
    void shouldCallPersistenceFindById () {
        givenQueryWithMockPersistence();
        whenQueryIsExecuted();
        thenVerifyQueryCallsPersistenceFindById();
    }
    
    private void givenQueryWithMockPersistence () {
        persistence = mock(EmployeeStorage.class);
        when(persistence.findById(id)).thenReturn(Optional.of(employee));
        query = new ReadEmployeeByIdQuery(persistence);
    }
    
    private Employee whenQueryIsExecuted () {
        return query.execute(id);
    }
    
    private void thenVerifyQueryCallsPersistenceFindById () {
        verify(persistence, times(1)).findById(id);
    }
    
    @Test
    void shouldReturnResultFromPersistenceFindById () {
        givenQueryWithMockPersistence();
        Employee result = whenQueryIsExecuted();
        thenVerifyFindByIdResultIsReturned(result);
    }
    
    private void thenVerifyFindByIdResultIsReturned (Employee result) {
        assertThat(result).isSameAs(employee);
    }
    
    @Test
    void shouldThrowWhenEmployeeIsNotFound () {
        givenQueryWithMockThatThrowsException();
        thenAssertQueryThrowsEmployeeNotFoundException();
    }
    
    private void givenQueryWithMockThatThrowsException () {
        persistence = mock(EmployeeStorage.class);
        when(persistence.findById(id)).thenThrow(EmployeeNotFoundException.class);
        query = new ReadEmployeeByIdQuery(persistence);
    }
    
    private void thenAssertQueryThrowsEmployeeNotFoundException () {
        assertThrows(EmployeeNotFoundException.class, () -> query.execute(id));
    }
}
