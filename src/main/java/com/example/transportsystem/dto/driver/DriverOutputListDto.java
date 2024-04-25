package com.example.transportsystem.dto.driver;

import java.io.Serializable;

/**
 * DTO for {@link com.example.transportsystem.model.driver.Driver}
 */
public record DriverOutputListDto(Long id, String name, String surname, String patronymic, String passportNumber,
                                  String nationality) implements Serializable {
}