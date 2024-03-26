package com.example.transportsystem.mapper;

import com.example.transportsystem.dto.order.input.OrderInputDto;
import com.example.transportsystem.model.order.Order;
import com.example.transportsystem.dto.order.output.OrderOutputDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING, uses = {ClientMapper.class, DeliveryMapper.class})
public interface OrderMapper {
    Order toEntity(OrderInputDto orderInputDto);

    @AfterMapping
    default void linkDeliveries(@MappingTarget Order order) {
        order.getDeliveries().forEach(delivery -> delivery.setOrder(order));
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order partialUpdate(OrderInputDto orderInputDto, @MappingTarget Order order);

    @Mapping(target = "clientName", source = "client.name")
    OrderOutputDto toDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order partialUpdate(OrderOutputDto orderOutputDto, @MappingTarget Order order);
}