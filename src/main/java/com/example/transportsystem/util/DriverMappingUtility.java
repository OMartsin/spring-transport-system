package com.example.transportsystem.util;

import com.example.transportsystem.dto.driver.DriverDto;
import com.example.transportsystem.dto.driver.DriverLicenseDto;
import com.example.transportsystem.mapper.DriverMapper;
import com.example.transportsystem.model.driver.Driver;
import com.example.transportsystem.model.driver.DriverLicenseCategory;
import com.example.transportsystem.repository.DriverLicenseCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class DriverMappingUtility {
    private final DriverLicenseCategoryRepository driverLicenseCategoryRepository;
    private final DriverMapper driverMapper;

    public Driver toEntity(DriverDto driverDto) {
        Driver driver = driverMapper.toEntity(driverDto);
        return setLicenseCategories(driverDto, driver);
    }

    public DriverDto toDto(Driver driver) {
        DriverDto driverDto = driverMapper.toDto(driver);
        driverDto.getDriverLicenses().forEach(licenseDto -> driver.getDriverLicenses().stream()
                .filter(license -> license.getNumber().equals(licenseDto.getNumber()))
                .findFirst()
                .ifPresent(license -> licenseDto.setLicenseCategories(parseCategories(license.getCategories()))));
        return driverDto;
    }

    public Driver partialUpdate(DriverDto driverDto, Driver driver) {
        driverMapper.partialUpdate(driverDto, driver);
        return setLicenseCategories(driverDto, driver);
    }

    private Driver setLicenseCategories(DriverDto driverDto, Driver driver) {
        driver.getDriverLicenses().forEach(driverLicense -> {
            DriverLicenseDto licenseDto = driverDto.getDriverLicenses().stream()
                    .filter(dto -> dto.getNumber().equals(driverLicense.getNumber()))
                    .findFirst()
                    .orElse(null);
            if (licenseDto != null) {
                Set<DriverLicenseCategory> categories = parseAndFindCategories(licenseDto.getLicenseCategories());
                driverLicense.setCategories(categories);
            }
        });
        return driver;
    }

    private Set<DriverLicenseCategory> parseAndFindCategories(String licenseCategories) {
        if (licenseCategories == null || licenseCategories.isEmpty()) {
            return Set.of();
        }
        Set<String> categoryNames = Arrays.stream(licenseCategories.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
        return driverLicenseCategoryRepository.findByNameIn(categoryNames);
    }

    private String parseCategories(Set<DriverLicenseCategory> categories) {
        if (categories == null || categories.isEmpty()) {
            return "";
        }
        return categories.stream()
                .map(DriverLicenseCategory::getName)
                .collect(Collectors.joining(", "));
    }

}
