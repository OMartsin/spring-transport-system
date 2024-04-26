package com.example.transportsystem.mapper;

import com.example.transportsystem.dto.order.input.DeliveryInputDto;
import com.example.transportsystem.dto.order.output.DeliveryOutputDto;
import com.example.transportsystem.dto.trailer.TrailerOutputListDto;
import com.example.transportsystem.dto.truck.TruckOutputListDto;
import com.example.transportsystem.model.order.Delivery;
import com.example.transportsystem.model.transport.trailer.Trailer;
import com.example.transportsystem.model.transport.truck.Truck;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeliveryMapper {
    @Mapping(target = "truck", source = "truck", qualifiedByName = "brandModelTruck")
    @Mapping(target = "trailer", source = "trailer", qualifiedByName = "brandModel")
    DeliveryOutputDto toDto(Delivery delivery);

    @Named("brandModelTruck")
    default TruckOutputListDto brandModelTruck(Truck truck) {
        return new TruckOutputListDto(truck.getId(), truck.getBrand(), truck.getModel(),
                truck.getRegistrationNumber(), truck.getWeight());
    }

    @Named("brandModel")
    default TrailerOutputListDto brandModel(Trailer trailer) {
        return new TrailerOutputListDto(trailer.getId(),
                trailer.getBrand(), trailer.getModel(), trailer.getRegistrationNumber(), trailer.getWeight());
    }
    Delivery toEntity(DeliveryInputDto deliveryInputDto);
}