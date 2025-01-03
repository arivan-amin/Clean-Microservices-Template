package com.arivanamin.app.name.backend.audit.storage;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditEventRepository extends MongoRepository<JpaAuditEvent, String> {
    
    List<JpaAuditEvent> findAllByRecordedAtBetween (LocalDateTime start, LocalDateTime end);
}
