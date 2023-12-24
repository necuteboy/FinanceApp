package com.example.financeapp.controller;

import com.example.financeapp.dto.request.CategoryRequestDto;
import com.example.financeapp.dto.response.CategoryResponseDto;
import com.example.financeapp.mapper.CategoryMapper;
import com.example.financeapp.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

//    @PostMapping("/create")
//    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto categoryRequestDto){
//        return categoryMapper.fromModelToDto(categoryService.)
//    }
    @GetMapping("/get/{id}")
    public CategoryResponseDto getCategory(@PathVariable @Valid int id){
        return categoryMapper.fromModelToDto(categoryService.getCategoryById(id));
    }
}
