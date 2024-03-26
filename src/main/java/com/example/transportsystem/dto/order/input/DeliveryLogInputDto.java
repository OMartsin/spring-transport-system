package com.example.transportsystem.dto.order.input;

import com.example.transportsystem.model.order.DeliveryLog;
import com.example.transportsystem.model.order.DeliveryStatus;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link DeliveryLog}
 */
public record DeliveryLogInputDto(String description, Timestamp timestamp, Float latitude, Float longitude,
                                  String address, DeliveryStatus status) implements Serializable {
}