package com.arivanamin.app.name.backend.base.domain.aspects;

import java.lang.annotation.*;

@Target (ElementType.METHOD)
@Retention (RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
    
}
