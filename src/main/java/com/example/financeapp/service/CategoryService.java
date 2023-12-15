package com.example.financeapp.service;

import com.example.financeapp.model.CategoryEntity;
import com.example.financeapp.repository.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoriesRepository categoriesRepository;

    public CategoryEntity getCategoryById(int id){
        return categoriesRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
