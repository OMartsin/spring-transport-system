package com.example.transportsystem.mapper;

import com.example.transportsystem.dto.order.input.DeliveryLogInputDto;
import com.example.transportsystem.model.order.DeliveryLog;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeliveryLogMapper {
    DeliveryLog toEntity(DeliveryLogInputDto deliveryLogInputDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DeliveryLog partialUpdate(DeliveryLogInputDto deliveryLogInputDto, @MappingTarget DeliveryLog deliveryLog);
}