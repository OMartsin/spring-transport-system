package com.example.transportsystem.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * DTO for {@link com.example.transportsystem.model.driver.Driver}
 */
@Data
public class DriverDto implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String passportNumber;
    private String nationality;
    private String phoneNumber;
    private String ipn;
    private Date birthDate;
    private UserDto user;
    private Set<DriverContractInputDto> driverContract;
    private Set<DriverLicenseDto> driverLicenses;
}