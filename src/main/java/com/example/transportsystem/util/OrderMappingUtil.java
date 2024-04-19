package com.example.transportsystem.util;

import com.example.transportsystem.dto.order.input.DeliveryInputDto;
import com.example.transportsystem.dto.order.input.OrderInputDto;
import com.example.transportsystem.mapper.DeliveryMapper;
import com.example.transportsystem.mapper.OrderMapper;
import com.example.transportsystem.model.order.Delivery;
import com.example.transportsystem.model.order.Order;
import com.example.transportsystem.repository.ClientRepository;
import com.example.transportsystem.repository.DriverRepository;
import com.example.transportsystem.repository.TrailerRepository;
import com.example.transportsystem.repository.TruckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMappingUtil {
    private final ClientRepository clientRepository;
    private final TruckRepository truckRepository;
    private final TrailerRepository trailerRepository;
    private final DriverRepository driverRepository;
    private final OrderMapper orderMapper;
    private final DeliveryMapper deliveryMapper;
    public Order toEntity(OrderInputDto orderInputDto) {
        Order order = orderMapper.toEntity(orderInputDto);
        order.setClient(clientRepository.findById(orderInputDto.clientId()).orElse(null));
        order.setDelivery(deliveryMapper.toEntity(orderInputDto.delivery()));
        order.getDelivery().setOrder(order);
        System.out.println(order);
        return order;
    }

    private Delivery deliveryDtoToEntity(DeliveryInputDto deliveryInputDto) {
        Delivery delivery = deliveryMapper.toEntity(deliveryInputDto);
        delivery.setTruck(truckRepository.findById(deliveryInputDto.truckId()).orElse(null));
        delivery.setTrailer(trailerRepository.findById(deliveryInputDto.trailerId()).orElse(null));
        delivery.setDriver(driverRepository.findById(deliveryInputDto.driverId()).orElse(null));
        return delivery;
    }
}
