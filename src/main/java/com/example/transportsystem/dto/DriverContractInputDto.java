package com.example.transportsystem.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.example.transportsystem.model.driver.DriverContract}
 */
public record DriverContractInputDto(Integer number, Date issueDate, Date expirationDate) implements Serializable {
}