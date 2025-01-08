package com.arivanamin.app.name.backend.audit.core.exception;

public class AuditEventNotFoundException extends RuntimeException {
    
    public AuditEventNotFoundException () {
        super("AuditEvent by the requested id not found");
    }
}
