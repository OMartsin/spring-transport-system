package com.example.transportsystem.dto.order.input;

import com.example.transportsystem.model.order.Order;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link Order}
 */
public record OrderInputDto(@NotNull Long id,@NotNull String name,@NotNull Long clientId,@NotNull Double price,
                            @NotNull Timestamp departureDate, @NotNull DeliveryInputDto delivery) implements Serializable {
}