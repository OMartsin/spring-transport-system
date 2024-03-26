package com.example.transportsystem.service.order;

import com.example.transportsystem.dto.order.input.DeliveryLogInputDto;
import com.example.transportsystem.dto.order.output.DeliveryOutputDto;
import com.example.transportsystem.dto.order.input.OrderInputDto;
import com.example.transportsystem.dto.order.output.OrderOutputDto;
import com.example.transportsystem.mapper.DeliveryLogMapper;
import com.example.transportsystem.mapper.DeliveryMapper;
import com.example.transportsystem.mapper.OrderMapper;
import com.example.transportsystem.model.order.Order;
import com.example.transportsystem.repository.DeliveryLogRepository;
import com.example.transportsystem.repository.DeliveryRepository;
import com.example.transportsystem.repository.OrderRepository;
import com.example.transportsystem.util.OrderMappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<OrderOutputDto> findAll() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).toList();
    }

    @Override
    public OrderOutputDto findById(Long id) {
        return orderRepository.findById(id).map(orderMapper::toDto).orElseThrow();
    }

    @Override
    public OrderOutputDto save(OrderInputDto order) {
        Order order1 = orderMappingUtil.toEntity(order);
        var resultOrder = orderMapper.toDto(orderRepository.save(order1));
        deliveryRepository.saveAll(order1.getDeliveries());
        return resultOrder;
    }

    @Override
    public OrderOutputDto update(OrderInputDto order) {
        return orderMapper.toDto(orderRepository.save(orderMappingUtil.toEntity(order)));
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
}
