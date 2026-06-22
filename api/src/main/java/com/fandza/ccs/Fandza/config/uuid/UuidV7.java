package com.fandza.ccs.Fandza.config.uuid;


import org.hibernate.annotations.IdGeneratorType;
import java.lang.annotation.*;

@IdGeneratorType(UuidV7IdentifierGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface UuidV7 {
}