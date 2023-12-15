package com.example.financeapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonRequestDto {
    private String email;
    private String phoneNumber;
    private String name;
    private String password;
    private String confirmPassword;
}
