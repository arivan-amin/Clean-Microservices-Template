package com.arivanamin.app.name.backend.audit.core.query;

import com.arivanamin.app.name.backend.audit.core.persistence.AuditEventStorage;
import com.arivanamin.app.name.backend.base.domain.audit.AuditEvent;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReadAuditEventsByCriteriaQuery {
    
    private final AuditEventStorage storage;
    
    public List<AuditEvent> execute (AuditEvent criteria) {
        return storage.findAllByCriteria(criteria);
    }
}
