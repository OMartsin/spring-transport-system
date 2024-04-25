package com.example.transportsystem.service.order;


import com.example.transportsystem.dto.order.input.DeliveryLogInputDto;
import com.example.transportsystem.dto.order.input.OrderInputDto;
import com.example.transportsystem.dto.order.output.DeliveryOutputDto;
import com.example.transportsystem.dto.order.output.OrderForAddData;
import com.example.transportsystem.dto.order.output.OrderOutputDto;
import com.example.transportsystem.dto.order.output.OrderOutputListDto;

import java.util.List;

public interface OrderService {
    List<OrderOutputListDto> findAll();
    OrderOutputDto findById(Long id);
    OrderOutputDto save(OrderInputDto order);
    OrderOutputDto update(OrderInputDto order);
    void deleteById(Long id);
    DeliveryOutputDto addDeliveryLog(Long deliveryId, DeliveryLogInputDto deliveryLog);
    OrderForAddData findDataForAdd();
}
