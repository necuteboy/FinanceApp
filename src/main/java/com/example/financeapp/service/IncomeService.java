package com.example.financeapp.service;

import com.example.financeapp.model.IncomeEntity;
import com.example.financeapp.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeService {
    private final IncomeRepository incomeRepository;
    private final PersonService personService;
    private final CategoryService categoryService;
    private final CurrencyService currencyService;

    public IncomeEntity createIncome(IncomeEntity incomeEntity,
                                     long userId,
                                     int categoryId,
                                     long currencyId) {
        incomeEntity.setUserid(personService.getPersonById(userId));
        incomeEntity.setCategoryid(categoryService.getCategoryById(categoryId));
        incomeEntity.setCurrencyid(currencyService.getCurrencyById(currencyId));
        incomeEntity.setCreatedAt(LocalDateTime.now());
        return incomeRepository.save(incomeEntity);

    }

    public List<IncomeEntity> getAllById(Long id) {
        return incomeRepository.findAllByUserid(personService.getPersonById(id));
    }


    public void deleteById(Long id){
        incomeRepository.deleteById(id);
    }
}
