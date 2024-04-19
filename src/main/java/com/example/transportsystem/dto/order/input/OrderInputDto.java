package com.example.transportsystem.dto.order.input;

import com.example.transportsystem.model.order.Order;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link Order}
 */
public record OrderInputDto(Long id, String name, Long clientId, Double price, Timestamp departureDate,
                            DeliveryInputDto delivery) implements Serializable {
}