package com.example.transportsystem.dto.truck;

import com.example.transportsystem.dto.order.output.DeliveryOutputDto;

import java.util.List;

public record TruckOutputDto(Long id, String model, String brand, String registrationNumber,
                             Integer weight, Integer euroStandard, String fuelTyp, List<DeliveryOutputDto> deliveries) {
}
