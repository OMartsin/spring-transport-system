package com.example.transportsystem.dto.driver;

import com.example.transportsystem.dto.order.output.DeliveryOutputDto;
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
    private Set<DeliveryOutputDto> deliveries;
    private Set<DriverContractInputDto> driverContract;
    private Set<DriverLicenseDto> driverLicenses;
}