package com.example.financeapp.service;

import com.example.financeapp.model.CurrencyEntity;
import com.example.financeapp.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyEntity getCurrencyById(Long id) {
        return currencyRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
