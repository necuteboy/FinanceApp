package com.example.financeapp.mapper;

import com.example.financeapp.dto.request.CurrencyRequestDto;
import com.example.financeapp.dto.response.CurrencyResponseDto;
import com.example.financeapp.model.CurrencyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {
    CurrencyResponseDto fromModelToDto(CurrencyEntity currencyEntity);

    CurrencyEntity fromDtoToModel(CurrencyRequestDto currencyRequestDto);
}
