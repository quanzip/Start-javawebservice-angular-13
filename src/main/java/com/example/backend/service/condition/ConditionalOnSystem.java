package com.example.backend.service.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ConditionalOnSystem  implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println("OS information: " + System.getProperty("os.name"));
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}
