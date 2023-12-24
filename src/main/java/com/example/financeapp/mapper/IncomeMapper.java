package com.example.financeapp.mapper;

import com.example.financeapp.dto.request.IncomesRequestDto;
import com.example.financeapp.dto.response.IncomesResponseDto;
import com.example.financeapp.model.IncomeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeMapper {
    IncomesResponseDto fromModelToDto(IncomeEntity incomeEntity);

    IncomeEntity fromDtoToModel(IncomesRequestDto incomesRequestDto);
}
