package com.example.transportsystem.dto.order.input;

import com.example.transportsystem.model.order.Delivery;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Delivery}
 */
public record DeliveryInputDto(@NotNull Long id, @NotNull Long trailerId, @NotNull Long truckId, @NotNull Long driverId,
                               List<DeliveryLogInputDto> deliveryLogs) implements Serializable {
}