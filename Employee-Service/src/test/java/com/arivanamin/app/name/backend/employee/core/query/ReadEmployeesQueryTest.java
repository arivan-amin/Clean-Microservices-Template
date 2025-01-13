package com.arivanamin.app.name.backend.employee.core.query;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import com.arivanamin.app.name.backend.testing.architecture.bases.BaseUnitTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ReadEmployeesQueryTest implements BaseUnitTest {
    
    private final List<Employee> employees = List.of();
    private EmployeeStorage persistence;
    private ReadEmployeesQuery query;
    
    @Test
    void shouldCallPersistenceFindAll () {
        givenQueryWithMockPersistence();
        whenQueryIsExecuted();
        thenVerifyQueryCallsFindAll();
    }
    
    private void givenQueryWithMockPersistence () {
        persistence = mock(EmployeeStorage.class);
        when(persistence.findAll()).thenReturn(employees);
        query = new ReadEmployeesQuery(persistence);
    }
    
    private List<Employee> whenQueryIsExecuted () {
        return query.execute();
    }
    
    private void thenVerifyQueryCallsFindAll () {
        verify(persistence, times(1)).findAll();
    }
    
    @Test
    void shouldReturnResultOfPersistenceFindAll () {
        givenQueryWithMockPersistence();
        List<Employee> result = whenQueryIsExecuted();
        thenVerifyFindAllResultIsReturned(result);
    }
    
    private void thenVerifyFindAllResultIsReturned (List<Employee> result) {
        assertThat(employees).isSameAs(result);
    }
}
