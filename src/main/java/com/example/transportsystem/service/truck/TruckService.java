package com.example.transportsystem.service.truck;

import com.example.transportsystem.dto.truck.TruckInputDto;
import com.example.transportsystem.dto.truck.TruckOutputDto;

import java.util.List;

public interface TruckService {
    List<TruckOutputDto> findAll();
    TruckOutputDto findById(Long id);
    TruckOutputDto save(TruckInputDto truck);
    TruckOutputDto update(TruckInputDto truck);
    void deleteById(Long id);
}
