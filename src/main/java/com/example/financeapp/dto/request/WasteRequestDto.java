package com.example.financeapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WasteRequestDto {
    private Long userid;
    private int category;
    private Long currency;
    private Double sum;
}
