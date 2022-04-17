package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class ListenerConfig {
    @Bean
    public SimpleAsyncTaskExecutor getExecutor(){  // TaskExecutor
        return new SimpleAsyncTaskExecutor();
    }
}
