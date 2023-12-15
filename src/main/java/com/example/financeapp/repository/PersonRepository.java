package com.example.financeapp.repository;

import com.example.financeapp.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByName(String username);
}
