package com.example.backend.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@AllArgsConstructor
@ConfigurationProperties(prefix = "quanzip", ignoreInvalidFields = true, ignoreUnknownFields = true)
public class QuanzipConfig {
    private String name;
    private int age;
    private String major;

    public QuanzipConfig() {
        System.out.println(this.getClass().getName() + " created because it was not created befored");
    }

    @Value("${period:not found value}")
    private String period;
}
