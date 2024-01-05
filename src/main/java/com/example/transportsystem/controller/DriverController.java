package com.example.transportsystem.controller;

import com.example.transportsystem.dto.DriverDto;
import com.example.transportsystem.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping
    public List<DriverDto> findAll() {
        return driverService.findAll();
    }

    @GetMapping("/{id}")
    public DriverDto findById(@PathVariable Long id) {
        return driverService.findById(id);
    }

    @PostMapping
    public DriverDto create(DriverDto driverDto) {
        return driverService.save(driverDto);
    }

    @PutMapping("/{id}")
    public DriverDto update(@PathVariable Long id, DriverDto driverDto) {
        driverDto.setId(id);
        return driverService.update(driverDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        driverService.deleteById(id);
    }
}