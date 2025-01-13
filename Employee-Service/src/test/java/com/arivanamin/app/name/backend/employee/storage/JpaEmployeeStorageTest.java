package com.arivanamin.app.name.backend.employee.storage;

import com.arivanamin.app.name.backend.testing.architecture.bases.BaseUnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class JpaEmployeeStorageTest implements BaseUnitTest {
    
    @Mock
    EmployeeRepository repository;
    
    @InjectMocks
    JpaEmployeeStorage persistence;
    
    @Test
    void shouldReturnAllEmployeesFromRepository () {
        // given
        
        // when
        
        // then
    }
}
