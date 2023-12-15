package com.example.financeapp.repository;

import com.example.financeapp.model.IncomeEntity;
import com.example.financeapp.model.PersonEntity;
import com.example.financeapp.model.WasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WasteRepository extends JpaRepository<WasteEntity,Long> {

    List<WasteEntity> findAllByPerson(PersonEntity userid);
}
