package com.example.backend.service.condition;

import com.example.backend.service.exception.ExceptionHandler;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ConditionalOnValue implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        ClassLoader classLoader = context.getClassLoader();
        System.out.println("\n Class loader: \n" + classLoader.toString());

        Environment environment = context.getEnvironment();
        System.out.println("\n ENV: \n" + environment);

        ExceptionHandler exceptionHandler = context.getBeanFactory().getBean(ExceptionHandler.class);
        System.out.println("\n getBeanFactory().getBean: \n" + exceptionHandler);
        return 100 > 20;
    }
}
