package com.example.transportsystem.dto.order.input;

import com.example.transportsystem.model.order.Order;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * DTO for {@link Order}
 */
public record OrderInputDto(Long id, String name, Long clientId, Double price, Timestamp departureDate,
                            List<DeliveryInputDto> deliveries) implements Serializable {
}