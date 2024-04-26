package com.example.transportsystem.dto.order.output;

import com.example.transportsystem.dto.client.ClientOutputListDto;
import com.example.transportsystem.model.order.Order;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link Order}
 */
public record OrderOutputDto(Long id, String name, ClientOutputListDto client, Double price, Timestamp departureDate,
                             DeliveryOutputDto delivery) implements Serializable {
}