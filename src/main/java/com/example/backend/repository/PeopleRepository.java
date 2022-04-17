package com.example.backend.repository;

import com.example.backend.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
    Optional<People> findByFirstNameAndIsActived(String firstName, int isActived);
}
