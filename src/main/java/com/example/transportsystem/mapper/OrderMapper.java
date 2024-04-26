package com.example.transportsystem.mapper;

import com.example.transportsystem.dto.client.ClientOutputListDto;
import com.example.transportsystem.dto.order.input.OrderInputDto;
import com.example.transportsystem.dto.order.output.OrderOutputListDto;
import com.example.transportsystem.model.Client;
import com.example.transportsystem.model.order.Order;
import com.example.transportsystem.dto.order.output.OrderOutputDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING, uses = { DeliveryMapper.class })
public interface OrderMapper {
    Order toEntity(OrderInputDto orderInputDto);

    @AfterMapping
    default void linkDeliveries(@MappingTarget Order order) {
        order.getDelivery().setOrder(order);
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order partialUpdate(OrderInputDto orderInputDto, @MappingTarget Order order);

    @Mapping(target = "client", source = "client", qualifiedByName = "clientOutputListDto")
    OrderOutputDto toDto(Order order);

    @Named("clientOutputListDto")
    default ClientOutputListDto clientOutputListDto(Client client) {
        return new ClientOutputListDto(client.getId(), client.getName(),
                client.getEdrpou(), client.getIban());
    }

    OrderOutputListDto toListDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order partialUpdate(OrderOutputDto orderOutputDto, @MappingTarget Order order);
}