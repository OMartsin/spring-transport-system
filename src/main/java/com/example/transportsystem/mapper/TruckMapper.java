package com.example.transportsystem.mapper;

import com.example.transportsystem.dto.truck.TruckInputDto;
import com.example.transportsystem.dto.truck.TruckOutputDto;
import com.example.transportsystem.model.transport.truck.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {DeliveryMapper.class})
public interface TruckMapper {

    Truck toEntity(TruckInputDto truckinputDto);

    TruckOutputDto toDto(Truck truck);

}
