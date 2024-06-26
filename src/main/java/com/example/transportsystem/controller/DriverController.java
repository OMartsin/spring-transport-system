package com.example.transportsystem.controller;

import com.example.transportsystem.dto.driver.DriverDto;
import com.example.transportsystem.dto.driver.DriverOutputListDto;
import com.example.transportsystem.service.driver.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping
    public List<DriverOutputListDto> findAll() {
        return driverService.findAll();
    }

    @GetMapping("/{id}")
    public DriverDto findById(@PathVariable Long id) {
        return driverService.findById(id);
    }

    @PostMapping
    public DriverDto create(@RequestBody DriverDto driverDto) {
        return driverService.save(driverDto);
    }

    @PutMapping
    public DriverDto update(@RequestBody DriverDto driverDto) {
        return driverService.update(driverDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        driverService.deleteById(id);
    }
}
