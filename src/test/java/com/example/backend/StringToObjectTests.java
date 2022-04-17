package com.example.backend;

import com.example.backend.entity.Symptoms;
import com.example.backend.service.converter.StringToObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
@ExtendWith(MockitoExtension.class)
public class StringToObjectTests {

    @InjectMocks
    private StringToObject stringToObject;

    @BeforeEach
    void init() {
        System.out.println("starting test: " + this.getClass().getCanonicalName());
    }

    @Test
    public void testConvert() {
        String input = "1, Quanzip";
        Symptoms symptoms = stringToObject.convert(input);
        System.out.println(symptoms);
        Assertions.assertNotNull(symptoms);
    }
}
