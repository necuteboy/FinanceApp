package com.example.financeapp.service;

import com.example.financeapp.dto.request.JwtRequest;
import com.example.financeapp.dto.request.PersonDto;
import com.example.financeapp.dto.request.PersonRequestDto;
import com.example.financeapp.dto.response.JwtResponse;
import com.example.financeapp.exceptions.AppError;
import com.example.financeapp.model.PersonEntity;
import com.example.financeapp.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PersonService userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword());
        try {
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(),
                    "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser(@RequestBody PersonRequestDto registrationUserDto) {
        if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пароли не совпадают"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userService.findByUserName(registrationUserDto.getName()).isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value()
                    , "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        PersonEntity user = userService.createPerson(registrationUserDto);
        return ResponseEntity.ok(new PersonDto(user.getUserid(), user.getName(),user.getEmail(),user.getPhoneNumber()));
    }
}
