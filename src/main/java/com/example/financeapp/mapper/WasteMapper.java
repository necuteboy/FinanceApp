package com.example.financeapp.mapper;

import com.example.financeapp.dto.request.WasteRequestDto;
import com.example.financeapp.dto.response.WasteResponseDto;
import com.example.financeapp.model.WasteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WasteMapper {
    WasteResponseDto fromModelToDto(WasteEntity wasteEntity);
    WasteEntity fromDtoToModel(WasteRequestDto wasteRequestDto);
}
