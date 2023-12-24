package com.example.financeapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDto {
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
}
