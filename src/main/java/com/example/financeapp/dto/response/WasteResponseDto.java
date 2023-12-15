package com.example.financeapp.dto.response;

import com.example.financeapp.model.CategoryEntity;
import com.example.financeapp.model.CurrencyEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WasteResponseDto {
    private Long wasteid;
    private CategoryResponseDto categoryid;
    private CurrencyResponseDto currencyid;
    private Double sum;
    private PersonResponseDto userid;
    private String createdAt;
}
