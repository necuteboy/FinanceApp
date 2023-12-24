package com.example.financeapp.controller;

import com.example.financeapp.dto.request.WasteRequestDto;
import com.example.financeapp.dto.response.WasteResponseDto;
import com.example.financeapp.mapper.WasteMapper;
import com.example.financeapp.model.WasteEntity;
import com.example.financeapp.service.WasteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wastes")
@RequiredArgsConstructor
public class WasteController {
    private final WasteService wasteService;
    private final WasteMapper wasteMapper;

    @PostMapping("/create")
    public WasteResponseDto createWaste(@RequestBody WasteRequestDto wasteRequestDto) {
        return wasteMapper.fromModelToDto(wasteService.createWaste(wasteMapper
                        .fromDtoToModel(wasteRequestDto),
                wasteRequestDto.getUserid(),
                wasteRequestDto.getCategory(),
                wasteRequestDto.getCurrency()));
    }


    @GetMapping("/get/all/{id}")
    public List<WasteResponseDto> getAll(@PathVariable @Valid Long id){
        List<WasteResponseDto> wasteResponseDtoList = new ArrayList<>();
        var wastes = wasteService.getAllByPerson(id);
        for(WasteEntity wasteEntity : wastes){
            wasteResponseDtoList.add(wasteMapper.fromModelToDto(wasteEntity));
        }
        return wasteResponseDtoList;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable @Valid Long id){
        wasteService.deleteById(id);
    }
}
