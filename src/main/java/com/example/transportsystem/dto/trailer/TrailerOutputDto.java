package com.example.transportsystem.dto.trailer;

import com.example.transportsystem.dto.order.output.DeliveryOutputDto;
import com.example.transportsystem.model.transport.trailer.Trailer;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Trailer}
 */
public record TrailerOutputDto(Long id, String brand, String model, String registrationNumber, Integer weight,
                               Integer capacity, String trailerType, List<DeliveryOutputDto> deliveries) implements Serializable {
}