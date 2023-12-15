package com.example.financeapp.service;

import com.example.financeapp.model.IncomeEntity;
import com.example.financeapp.model.WasteEntity;
import com.example.financeapp.repository.CategoriesRepository;
import com.example.financeapp.repository.CurrencyRepository;
import com.example.financeapp.repository.WasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WasteService {
    private final WasteRepository wasteRepository;
    private final PersonService personService;
    private final CurrencyService currencyService;
    private final CategoryService categoryService;

    public WasteEntity createWaste(WasteEntity wasteEntity,
                                   long userId,
                                   int categoryId,
                                   long currencyId) {
        wasteEntity.setPerson(personService.getPersonById(userId));
        wasteEntity.setCategoryid(categoryService.getCategoryById(categoryId));
        wasteEntity.setCurrencyid(currencyService.getCurrencyById(currencyId));
        wasteEntity.setCreatedAt(LocalDateTime.now());
        return wasteRepository.save(wasteEntity);

    }

    public WasteEntity getEntityById(Long id){
        return wasteRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<WasteEntity> getAllByPerson(Long id) {
        return wasteRepository.findAllByPerson(personService.getPersonById(id));
    }


    public void deleteById(Long id){
        wasteRepository.deleteById(id);
    }



}
