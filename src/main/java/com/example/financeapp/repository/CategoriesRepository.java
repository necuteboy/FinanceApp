package com.example.financeapp.repository;

import com.example.financeapp.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<CategoryEntity, Integer> {
}
