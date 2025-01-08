package com.arivanamin.app.name.backend.audit.core.command;

import com.arivanamin.app.name.backend.audit.core.persistence.AuditEventStorage;
import com.arivanamin.app.name.backend.base.domain.audit.AuditEvent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAuditEventCommand {
    
    private final AuditEventStorage storage;
    
    public String execute (AuditEvent event) {
        return storage.create(event);
    }
}
