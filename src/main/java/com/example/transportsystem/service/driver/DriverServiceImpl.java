package com.example.transportsystem.service.driver;

import com.example.transportsystem.dto.driver.DriverDto;
import com.example.transportsystem.dto.driver.DriverOutputListDto;
import com.example.transportsystem.mapper.DriverMapper;
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
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final DriverMappingUtility driverMappingUtility;
    private final DriverMapper driverMapper;
    private final UserRepository userRepository;

    public List<DriverOutputListDto> findAll() {
        return driverRepository.findAll().stream().map(driverMapper::toListDto).toList();
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
