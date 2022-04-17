package com.example.backend.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@ConfigurationProperties(prefix = "quanaqt", ignoreInvalidFields = true, ignoreUnknownFields = true)
public class QuanaqtConfig {

    public QuanaqtConfig() {
        System.out.println(this.getClass().getName()
                + " created because quanaqt.isSent = true and quanzip.enable= true");
    }

    private String name;
    private int age;
    private String major;

    @Value("${period:not found value}")
    private String period;

    @Value("${server.port:100}")
    int requireValue ;

}
