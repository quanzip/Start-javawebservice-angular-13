package com.example.backend.service;

import com.example.backend.service.condition.ConditionalOnSystem;
import com.example.backend.service.condition.ConditionalOnValue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented

@ConditionalOnJava(JavaVersion.EIGHT)
@ConditionalOnMissingClass
@Conditional({ConditionalOnSystem.class, ConditionalOnValue.class})
public @interface ConditionOnEnv {
}
