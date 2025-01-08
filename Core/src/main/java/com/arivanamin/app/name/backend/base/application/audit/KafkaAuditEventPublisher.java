package com.arivanamin.app.name.backend.base.application.audit;

import com.arivanamin.app.name.backend.base.domain.audit.AuditEvent;
import com.arivanamin.app.name.backend.base.domain.audit.AuditEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

@RequiredArgsConstructor
public class KafkaAuditEventPublisher implements AuditEventPublisher {
    
    private final KafkaTemplate<String, AuditEvent> kafkaTemplate;
    
    @Override
    public void sendAuditLog (String topic, AuditEvent event) {
        kafkaTemplate.send(topic, event);
    }
}
