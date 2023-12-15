package com.example.financeapp.controller;

import com.example.financeapp.dto.request.JwtRequest;
import com.example.financeapp.dto.request.PersonRequestDto;
import com.example.financeapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody PersonRequestDto registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }
}
