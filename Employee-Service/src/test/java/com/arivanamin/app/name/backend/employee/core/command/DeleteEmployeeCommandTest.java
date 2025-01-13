package com.arivanamin.app.name.backend.employee.core.command;

import com.arivanamin.app.name.backend.employee.core.persistence.EmployeeStorage;
import com.arivanamin.app.name.backend.testing.architecture.bases.BaseUnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DeleteEmployeeCommandTest implements BaseUnitTest {
    
    private final UUID id = UUID.randomUUID();
    
    private EmployeeStorage persistence;
    private DeleteEmployeeCommand command;
    
    @Test
    void shouldCallPersistenceDelete () {
        givenCommandWithMockPersistence();
        whenCommandIsExecuted(id);
        thenVerifyCommandCallsDelete();
    }
    
    private void givenCommandWithMockPersistence () {
        persistence = mock(EmployeeStorage.class);
        command = new DeleteEmployeeCommand(persistence);
    }
    
    private void whenCommandIsExecuted (UUID id) {
        command.execute(id);
    }
    
    private void thenVerifyCommandCallsDelete () {
        verify(persistence, times(1)).delete(id);
    }
    
    @Test
    void shouldSendIdToPersistence () {
        givenCommandWithMockPersistence();
        whenCommandIsExecuted(id);
        thenVerifyIdIsSentToPersistence();
    }
    
    private void thenVerifyIdIsSentToPersistence () {
        ArgumentCaptor<UUID> idCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(persistence).delete(idCaptor.capture());
        
        UUID capturedId = idCaptor.getValue();
        assertThat(id).isSameAs(capturedId);
    }
}
