package com.example.financeapp.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomesResponseDto {
    private Long incomeid;
    private CategoryResponseDto categoryid;
    private CurrencyResponseDto currencyid;
    private Double sum;
    private PersonResponseDto userid;
    private String createdAt;
}
