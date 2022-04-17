package com.example.backend.service;

import com.example.backend.entity.Symptoms;

import java.util.List;

public interface SymptomsService {
    List<Symptoms> getAllSymptoms();
    Symptoms addSymptoms(Symptoms symptoms);
}
