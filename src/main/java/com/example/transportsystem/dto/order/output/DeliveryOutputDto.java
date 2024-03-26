package com.example.transportsystem.dto.order.output;

import java.io.Serializable;
import java.util.List;


public record DeliveryOutputDto(Long id, String trailerNumber, String truckNumber, String driverName,
                                List<DeliveryLogOutputDto> deliveryLogs) implements Serializable {
}