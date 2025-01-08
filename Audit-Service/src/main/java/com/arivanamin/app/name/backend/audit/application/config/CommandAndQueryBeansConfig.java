package com.arivanamin.app.name.backend.audit.application.config;

import com.arivanamin.app.name.backend.audit.core.command.CreateAuditEventCommand;
import com.arivanamin.app.name.backend.audit.core.persistence.AuditEventStorage;
import com.arivanamin.app.name.backend.audit.core.query.*;
import com.arivanamin.app.name.backend.audit.storage.AuditEventRepository;
import com.arivanamin.app.name.backend.audit.storage.JpaAuditEventStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class CommandAndQueryBeansConfig {
    
    @Bean
    public AuditEventStorage storage (AuditEventRepository repository) {
        return new JpaAuditEventStorage(repository);
    }
    
    @Bean
    public ReadAuditEventsQuery readAuditEventsQuery (AuditEventStorage storage) {
        return new ReadAuditEventsQuery(storage);
    }
    
    @Bean
    public ReadAuditEventsByCriteriaQuery readByCriteriaQuery (AuditEventStorage storage) {
        return new ReadAuditEventsByCriteriaQuery(storage);
    }
    
    @Bean
    public ReadAuditEventByIdQuery readAuditEventByIdQuery (AuditEventStorage storage) {
        return new ReadAuditEventByIdQuery(storage);
    }
    
    @Bean
    public CreateAuditEventCommand createAuditEventCommand (AuditEventStorage storage) {
        return new CreateAuditEventCommand(storage);
    }
}
