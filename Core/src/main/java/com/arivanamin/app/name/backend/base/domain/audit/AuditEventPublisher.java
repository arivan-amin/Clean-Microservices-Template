package com.arivanamin.app.name.backend.base.domain.audit;

@FunctionalInterface
public interface AuditEventPublisher {
    
    void sendAuditLog (String topic, AuditEvent event);
}
