package com.example.financeapp.repository;

import com.example.financeapp.model.IncomeEntity;
import com.example.financeapp.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<IncomeEntity, Long> {
    List<IncomeEntity> findAllByUserid(PersonEntity userid);
}
