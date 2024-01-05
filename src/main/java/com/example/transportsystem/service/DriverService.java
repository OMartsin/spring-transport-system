package com.example.transportsystem.service;

import com.example.transportsystem.dto.DriverDto;
import com.example.transportsystem.model.User;
import com.example.transportsystem.model.driver.Driver;
import com.example.transportsystem.repository.DriverRepository;
import com.example.transportsystem.repository.UserRepository;
import com.example.transportsystem.util.DriverMappingUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;
    private final DriverMappingUtility driverMappingUtility;
    private final UserRepository userRepository;

    public List<DriverDto> findAll() {
        return driverRepository.findAll().stream().map(driverMappingUtility::toDto).toList();
    }

    public DriverDto findById(Long id) {
        return driverMappingUtility.toDto(driverRepository.findById(id).orElseThrow());
    }

    public DriverDto save(DriverDto driverDto) {
        Driver driver = driverMappingUtility.toEntity(driverDto);
        User user = userRepository.save(new User(driver.getIpn(), driver.getBirthDate().toString()));
        driver.setUser(user);
        driverRepository.save(driver);
        return driverMappingUtility.toDto(driver);
    }

    public DriverDto update(DriverDto driverDto) {
        Driver driver = driverRepository.findById(driverDto.getId()).orElseThrow();
        driver = driverMappingUtility.partialUpdate(driverDto, driver);
        driverRepository.save(driver);
        return driverMappingUtility.toDto(driver);
    }

    public void deleteById(Long id) {
        driverRepository.deleteById(id);
    }

}
