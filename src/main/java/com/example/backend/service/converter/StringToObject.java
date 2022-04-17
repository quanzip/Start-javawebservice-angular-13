package com.example.backend.service.converter;

import com.example.backend.entity.Symptoms;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@ConfigurationPropertiesBinding
public class StringToObject implements Converter<String, Symptoms> {

    @Override
    public Symptoms convert(String source) {
        Symptoms symptoms = new Symptoms();
        String []elements = source.trim().split(",");
        symptoms.setId(Integer.parseInt(elements[0]));
        symptoms.setName(elements[1]);
        symptoms.setCreateDate(LocalDateTime.now());
        return symptoms;
    }
}
