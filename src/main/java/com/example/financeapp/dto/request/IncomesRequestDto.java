package com.example.financeapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomesRequestDto {
    private Long user;
    private int category;
    private Long currency;
    private Double sum;
}
