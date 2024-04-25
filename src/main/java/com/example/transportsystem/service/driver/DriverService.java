package com.example.transportsystem.service.driver;

import com.example.transportsystem.dto.driver.DriverDto;
import com.example.transportsystem.dto.driver.DriverOutputListDto;

import java.util.List;

public interface DriverService {
    List<DriverOutputListDto> findAll();

    DriverDto findById(Long id);

    DriverDto save(DriverDto driverDto);

    DriverDto update(DriverDto driverDto);

    void deleteById(Long id);
}
