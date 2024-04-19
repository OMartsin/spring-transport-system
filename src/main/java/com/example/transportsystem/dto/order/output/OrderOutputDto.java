package com.example.transportsystem.dto.order.output;

import com.example.transportsystem.model.order.Order;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * DTO for {@link Order}
 */
public record OrderOutputDto(Long id, String name, String clientName, Double price, Timestamp departureDate,
                             DeliveryOutputDto delivery) implements Serializable {
}