package com.example.transportsystem.service.truck;

import com.example.transportsystem.dto.truck.TruckInputDto;
import com.example.transportsystem.dto.truck.TruckOutputDto;
import com.example.transportsystem.dto.truck.TruckOutputListDto;

import java.util.List;

public interface TruckService {
    List<TruckOutputListDto> findAll();
    TruckOutputDto findById(Long id);
    TruckOutputDto save(TruckInputDto truck);
    TruckOutputDto update(TruckInputDto truck);
    void deleteById(Long id);
}
