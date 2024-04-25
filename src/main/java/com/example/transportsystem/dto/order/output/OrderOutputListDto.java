package com.example.transportsystem.dto.order.output;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.example.transportsystem.model.order.Order}
 */
public record OrderOutputListDto(Long id, String name, Double price, Timestamp departureDate) implements Serializable {
}