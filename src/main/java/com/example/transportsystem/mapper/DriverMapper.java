package com.example.transportsystem.mapper;

import com.example.transportsystem.dto.driver.DriverDto;
import com.example.transportsystem.model.driver.*;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DriverMapper {
    @Mapping(source = "driverLicenses", target = "driverLicenses")
    Driver toEntity(DriverDto driverDto);

    @AfterMapping
    default void linkDriverLicenses(@MappingTarget Driver driver) {
        driver.getDriverLicenses().forEach(driverLicens -> driverLicens.setDriver(driver));
    }

    DriverDto toDto(Driver driver);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Driver partialUpdate(DriverDto driverDto, @MappingTarget Driver driver);
}