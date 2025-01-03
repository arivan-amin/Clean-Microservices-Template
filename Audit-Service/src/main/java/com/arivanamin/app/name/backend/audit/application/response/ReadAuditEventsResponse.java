package com.arivanamin.app.name.backend.audit.application.response;

import com.arivanamin.app.name.backend.base.domain.audit.AuditEvent;
import lombok.Value;

import java.util.List;

@Value
public class ReadAuditEventsResponse {
    
    List<AuditEventResponse> responses;
    
    public static ReadAuditEventsResponse of (List<AuditEvent> events) {
        return new ReadAuditEventsResponse(events.stream()
            .map(AuditEventResponse::of)
            .toList());
    }
}
