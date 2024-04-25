package com.example.transportsystem.controller;

import com.example.transportsystem.dto.truck.TruckInputDto;
import com.example.transportsystem.dto.truck.TruckOutputDto;
import com.example.transportsystem.dto.truck.TruckOutputListDto;
import com.example.transportsystem.service.truck.TruckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/truck")
@RequiredArgsConstructor
public class TruckController {
    private final TruckService truckService;

    @GetMapping
    public List<TruckOutputListDto> findAll() {
        return truckService.findAll();
    }

    @GetMapping("/{id}")
    public TruckOutputDto findById(@PathVariable Long id) {
        return truckService.findById(id);
    }

    @PostMapping
    public TruckOutputDto create(@RequestBody TruckInputDto truck) {
        return truckService.save(truck);
    }

    @PutMapping
    public TruckOutputDto update(@RequestBody TruckInputDto truck) {
        return truckService.update(truck);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        truckService.deleteById(id);
    }
}
