package com.example.backend.service.imp;

import com.example.backend.entity.Symptoms;
import com.example.backend.repository.SymptomsRepository;
import com.example.backend.service.SymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SymptomsServiceImpl implements SymptomsService {

    @Autowired
    private SymptomsRepository symptomsRepository;

    @Override
    public List<Symptoms> getAllSymptoms() {
        return symptomsRepository.findAll();
    }

    @Override
    public Symptoms addSymptoms(Symptoms symptoms) {
        if(!Objects.isNull(symptoms)) {
            return symptomsRepository.save(symptoms);
        }
        return null;
    }
}
