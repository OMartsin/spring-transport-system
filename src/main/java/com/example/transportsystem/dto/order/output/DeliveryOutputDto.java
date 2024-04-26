package com.example.transportsystem.dto.order.output;

import com.example.transportsystem.dto.driver.DriverOutputListDto;
import com.example.transportsystem.dto.trailer.TrailerOutputListDto;
import com.example.transportsystem.dto.truck.TruckOutputListDto;

import java.io.Serializable;
import java.util.List;


public record DeliveryOutputDto(Long id, TrailerOutputListDto trailer, TruckOutputListDto truck,
                                DriverOutputListDto driver, List<DeliveryLogOutputDto> deliveryLogs)
        implements Serializable {
}