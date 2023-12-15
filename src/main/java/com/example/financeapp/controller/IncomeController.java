package com.example.financeapp.controller;

import com.example.financeapp.dto.request.IncomesRequestDto;
import com.example.financeapp.dto.response.IncomesResponseDto;
import com.example.financeapp.mapper.IncomeMapper;
import com.example.financeapp.model.IncomeEntity;
import com.example.financeapp.service.IncomeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/income")
@RequiredArgsConstructor
public class IncomeController {
    private final IncomeService incomeService;
    private final IncomeMapper incomeMapper;

    @PostMapping("/create")
    public IncomesResponseDto createIncome(@RequestBody IncomesRequestDto incomesRequestDto){
        return incomeMapper.fromModelToDto(incomeService.createIncome(incomeMapper
                        .fromDtoToModel(incomesRequestDto),
                incomesRequestDto.getUser(),
                incomesRequestDto.getCategory(),
                incomesRequestDto.getCurrency()));
    }
    @GetMapping("/get/all/{id}")
    public List<IncomesResponseDto> getAll(@PathVariable @Valid Long id){
        List<IncomesResponseDto> incomesResponseDtoList = new ArrayList<>();
        var incomes = incomeService.getAllById(id);
        for(IncomeEntity incomeEntity : incomes){
            incomesResponseDtoList.add(incomeMapper.fromModelToDto(incomeEntity));
        }
        return incomesResponseDtoList;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable @Valid Long id){
        incomeService.deleteById(id);
    }
}
