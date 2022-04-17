package com.example.backend.repository;

import com.example.backend.entity.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomsRepository extends JpaRepository<Symptoms, Long> {
}
