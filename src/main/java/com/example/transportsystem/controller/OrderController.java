package com.example.transportsystem.controller;

import com.example.transportsystem.dto.order.input.DeliveryLogInputDto;
import com.example.transportsystem.dto.order.output.DeliveryOutputDto;
import com.example.transportsystem.dto.order.input.OrderInputDto;
import com.example.transportsystem.dto.order.output.OrderOutputDto;
import com.example.transportsystem.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderOutputDto> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderOutputDto findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public OrderOutputDto create(@RequestBody OrderInputDto order) {
        return orderService.save(order);
    }

    @PutMapping
    public OrderOutputDto update(@RequestBody OrderInputDto order) {
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    @PostMapping("/{deliveryId}/log")
    public DeliveryOutputDto addDeliveryLog(@PathVariable Long deliveryId,
                                            @RequestBody DeliveryLogInputDto deliveryLog) {
        return orderService.addDeliveryLog(deliveryId, deliveryLog);
    }
}
