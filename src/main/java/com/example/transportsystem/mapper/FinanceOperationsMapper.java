package com.example.transportsystem.mapper;

import com.example.transportsystem.dto.finoperations.FinanceOperationRequest;
import com.example.transportsystem.model.FinanceOperations;
import com.example.transportsystem.dto.finoperations.FinanceOperationResponse;
import com.example.transportsystem.model.order.Order;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FinanceOperationsMapper {
    @Mapping(source = "orderId", target = "order.id")
    @Mapping(target = "order", source = "orderId", qualifiedByName = "orderIdToOrder")
    FinanceOperations toEntity(FinanceOperationRequest financeOperationResponse);

    FinanceOperationResponse toDto(FinanceOperations financeOperations);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FinanceOperations partialUpdate(FinanceOperationResponse financeOperationResponse, @MappingTarget FinanceOperations financeOperations);

    @Named("orderIdToOrder")
    default Order orderIdToOrder(Long orderId) {
        if (orderId == null) {
            return null;
        }
        Order order = new Order();
        order.setId(orderId);
        return order;
    }
}
