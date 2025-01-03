package com.arivanamin.app.name.backend.audit.core.persistence;

import com.arivanamin.app.name.backend.base.domain.audit.AuditEvent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AuditEventStorage {
    
    List<AuditEvent> findAll (LocalDateTime start, LocalDateTime end);
    
    List<AuditEvent> findAllByCriteria (AuditEvent criteria);
    
    Optional<AuditEvent> findById (String id);
    
    String create (AuditEvent event);
}
