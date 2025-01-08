package com.arivanamin.app.name.backend.audit.application.response;

import com.arivanamin.app.name.backend.base.domain.audit.AuditEvent;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

import static com.arivanamin.app.name.backend.base.domain.dates.TimestampHelper.toLocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditEventResponse {
    
    private String id;
    private String serviceName;
    private String location;
    private String action;
    private String data;
    private LocalDateTime dateTime;
    
    public static AuditEventResponse of (AuditEvent event) {
        AuditEventResponse response = new ModelMapper().map(event, AuditEventResponse.class);
        response.setDateTime(toLocalDateTime(event.getTimestamp()));
        return response;
    }
}
