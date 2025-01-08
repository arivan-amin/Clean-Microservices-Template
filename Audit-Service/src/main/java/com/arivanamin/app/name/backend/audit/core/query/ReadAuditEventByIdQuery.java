package com.arivanamin.app.name.backend.audit.core.query;

import com.arivanamin.app.name.backend.audit.core.exception.AuditEventNotFoundException;
import com.arivanamin.app.name.backend.audit.core.persistence.AuditEventStorage;
import com.arivanamin.app.name.backend.base.domain.audit.AuditEvent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReadAuditEventByIdQuery {
    
    private final AuditEventStorage storage;
    
    public AuditEvent execute (String id) {
        return storage.findById(id)
            .orElseThrow(AuditEventNotFoundException::new);
    }
}
