package com.example.backend;

import com.example.backend.entity.Symptoms;
import com.example.backend.repository.SymptomsRepository;
import com.example.backend.service.SymptomsService;
import com.example.backend.service.imp.SymptomsServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@TestConfiguration
@ExtendWith(MockitoExtension.class)
public class SymptomsServiceImplTests {
    @InjectMocks
    private SymptomsServiceImpl symptomsServiceImpl;

    @Mock
    private SymptomsRepository symptomsRepository;

    @BeforeEach
    public void setup(){
//
        final IntFunction<String> intFunction = t -> (t + 1 ) + " To String";
        List<String> strings = IntStream
                .range(0, 10).limit(8).mapToObj(intFunction).collect(Collectors.toList());

        System.out.println(strings);

        List<Symptoms> symptoms = new ArrayList<>();
        Mockito.lenient();
        Mockito.lenient().when(symptomsRepository.findAll())
                .thenReturn(symptoms);

        Assertions.assertNotEquals(1, symptoms.size());
    }

    @Test
    public void getAllSymptoms(){
        List<Symptoms> symptoms = new ArrayList<>();
        Mockito.lenient().when(symptomsServiceImpl.getAllSymptoms()).thenReturn(symptoms);
        System.out.println(symptoms);
    }

    @Test
    public void addSymptom(){
        Symptoms symptoms= new Symptoms(10, "quanaqt", LocalDateTime.now());
        Symptoms temp = symptomsServiceImpl.addSymptoms(symptoms);
        System.out.println(temp);
    }
}
