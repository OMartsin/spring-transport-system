package com.example.transportsystem.dto.truck;

import java.io.Serializable;

public record TruckOutputListDto(Long id, String brand, String model, String registrationNumber,
                                 Integer weight) implements Serializable {
}
