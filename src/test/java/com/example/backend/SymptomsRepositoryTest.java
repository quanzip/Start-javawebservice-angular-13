package com.example.backend;

import com.example.backend.entity.Symptoms;
import com.example.backend.repository.SymptomsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestConfiguration;

import java.util.ArrayList;
import java.util.List;

@TestConfiguration
@ExtendWith(MockitoExtension.class)
//@DataJpaTest
//@AutoConfigureTestDatabase
public class SymptomsRepositoryTest {
    @Mock
    private SymptomsRepository symptomsRepository;

    @Test
    public void test() {
        List<Symptoms> symptoms = new ArrayList<>();
        symptoms = symptomsRepository.findAll();
        System.out.println(symptoms);
    }
}
