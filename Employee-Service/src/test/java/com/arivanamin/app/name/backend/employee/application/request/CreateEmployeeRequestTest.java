package com.arivanamin.app.name.backend.employee.application.request;

import com.arivanamin.app.name.backend.employee.core.entity.Employee;
import com.arivanamin.app.name.backend.testing.architecture.bases.BaseUnitTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.arivanamin.app.name.backend.base.domain.dates.TimestampHelper.toLocalDateTime;
import static com.arivanamin.app.name.backend.base.domain.dates.TimestampHelper.toTimestampInMilliseconds;
import static org.assertj.core.api.Assertions.assertThat;

class CreateEmployeeRequestTest implements BaseUnitTest {
    
    @Test
    void shouldMapRequestToEntityCorrectly () {
        // given
        CreateEmployeeRequest request = RANDOM.nextObject(CreateEmployeeRequest.class);
        request.setDateOfBirth(toTimestampInMilliseconds(LocalDateTime.now()));
        
        // when
        Employee entity = request.toEntity();
        
        // then
        assertThat(request.getName()).isEqualTo(entity.getName());
        assertThat(request.getAddress()).isEqualTo(entity.getAddress());
        assertThat(toLocalDateTime(request.getDateOfBirth()).toLocalDate()).isEqualTo(
            entity.getDateOfBirth());
    }
}
