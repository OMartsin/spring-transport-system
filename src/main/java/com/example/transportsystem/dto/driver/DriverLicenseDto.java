package com.example.transportsystem.dto.driver;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.example.transportsystem.model.driver.DriverLicense}
 */
@Data
@AllArgsConstructor
public class DriverLicenseDto implements Serializable {
    private String number;
    private Date issueDate;
    private Date expirationDate;
    private String licenseCategories;
}