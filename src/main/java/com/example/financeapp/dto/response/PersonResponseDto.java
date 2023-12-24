package com.example.financeapp.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponseDto {
    private Long id;
    private String email;
    private String phoneNumber;
    private String name;
    private String password;
}
