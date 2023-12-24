package com.example.financeapp.mapper;

import com.example.financeapp.dto.request.CategoryRequestDto;
import com.example.financeapp.dto.response.CategoryResponseDto;
import com.example.financeapp.model.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDto fromModelToDto(CategoryEntity category);

    CategoryEntity fromDtoToModel(CategoryRequestDto categoryRequestDto);
}
