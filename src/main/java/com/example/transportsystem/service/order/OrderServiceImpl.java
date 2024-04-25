package com.example.transportsystem.service.order;

import com.example.transportsystem.dto.order.input.DeliveryLogInputDto;
import com.example.transportsystem.dto.order.output.DeliveryOutputDto;
import com.example.transportsystem.dto.order.input.OrderInputDto;
import com.example.transportsystem.dto.order.output.OrderForAddData;
import com.example.transportsystem.dto.order.output.OrderOutputDto;
import com.example.transportsystem.dto.order.output.OrderOutputListDto;
import com.example.transportsystem.mapper.DeliveryLogMapper;
import com.example.transportsystem.mapper.DeliveryMapper;
import com.example.transportsystem.mapper.OrderMapper;
import com.example.transportsystem.model.order.Order;
import com.example.transportsystem.repository.*;
import com.example.transportsystem.util.OrderMappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderMappingUtil orderMappingUtil;
    private final DeliveryLogMapper deliveryLogMapper;
    private final DeliveryMapper deliveryMapper;
    private final OrderRepository orderRepository;
    private final DeliveryRepository deliveryRepository;
    private final DeliveryLogRepository deliveryLogRepository;
    private final ClientRepository clientRepository;
    private final TrailerRepository trailerRepository;
    private final TruckRepository truckRepository;
    private final DriverRepository driverRepository;

    @Override
    public List<OrderOutputListDto> findAll() {
        return orderRepository.findAll().stream().map(orderMapper::toListDto).toList();
    }

    @Override
    public OrderOutputDto findById(Long id) {
        return orderRepository.findById(id).map(orderMapper::toDto).orElseThrow();
    }

    @Override
    public OrderOutputDto save(OrderInputDto order) {
        Order order1 = orderMappingUtil.toEntity(order);
        var resultOrder = orderMapper.toDto(orderRepository.save(order1));
        return resultOrder;
    }

    @Override
    public OrderOutputDto update(OrderInputDto order) {
        Order order1 = orderMappingUtil.toEntity(order);
        var delivery = deliveryRepository.findById(order1.getDelivery().getId()).orElseThrow();
        var client = clientRepository.findById(order.clientId()).orElseThrow();
        var trailer = trailerRepository.findById(order.delivery().trailerId()).orElseThrow();
        var truck = truckRepository.findById(order.delivery().truckId()).orElseThrow();
        var driver = driverRepository.findById(order.delivery().driverId()).orElseThrow();
        order1.setClient(client);
        delivery.setTrailer(trailer);
        delivery.setTruck(truck);
        delivery.setDriver(driver);
        order1.setDelivery(delivery);

        return orderMapper.toDto(orderRepository.save(order1));
    }

    @Override
    public void deleteById(Long id) {
       orderRepository.deleteById(id);
    }

    @Override
    public DeliveryOutputDto addDeliveryLog(Long deliveryId, DeliveryLogInputDto deliveryLog) {
        var delivery = deliveryRepository.findById(deliveryId).orElseThrow();
        deliveryLogRepository.save(deliveryLogMapper.toEntity(deliveryLog));
        return deliveryMapper.toDto(delivery);
    }

    @Override
    public OrderForAddData findDataForAdd() {
        var data = new OrderForAddData();
        data.setTrailers(trailerRepository.findAll().stream().map(trailer -> new OrderForAddData
                .IdName(trailer.getId(), trailer.getRegistrationNumber())).collect(Collectors.toList()));
        data.setTrucks(truckRepository.findAll().stream().map(truck -> new OrderForAddData
                .IdName(truck.getId(), truck.getRegistrationNumber())).collect(Collectors.toList()));
        data.setDrivers(driverRepository.findAll().stream().map(driver -> new OrderForAddData
                .IdName(driver.getId(), driver.getFullName())).collect(Collectors.toList()));
        data.setClients(clientRepository.findAll().stream().map(client -> new OrderForAddData
                .IdName(client.getId(), client.getName())).collect(Collectors.toList()));

        return data;
    }
}
