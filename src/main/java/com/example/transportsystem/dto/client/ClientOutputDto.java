package com.example.transportsystem.dto.client;


import com.example.transportsystem.dto.order.output.OrderOutputDto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.transportsystem.model.Client}
 */
public record ClientOutputDto(Long id, String name, String address, String edrpou, String ipn, String iban, String bank,
                              String mfo, List<OrderOutputDto> orders) implements Serializable {
}