package com.example.transportsystem.mapper;

import com.example.transportsystem.dto.order.input.DeliveryInputDto;
import com.example.transportsystem.dto.order.output.DeliveryOutputDto;
import com.example.transportsystem.model.driver.Driver;
import com.example.transportsystem.model.order.Delivery;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeliveryMapper {
    @Mapping(target = "driverName", source = "driver", qualifiedByName = "driverName")
    @Mapping(target = "trailerNumber", source = "trailer.registrationNumber")
    @Mapping(target = "truckNumber", source = "truck.registrationNumber")
    DeliveryOutputDto toDto(Delivery delivery);

    @Named("driverName")
    default String driverName(Driver driver) {
        return driver.getName() + " " + driver.getSurname();
    }

    Delivery toEntity(DeliveryInputDto deliveryInputDto);
}