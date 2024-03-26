package com.example.transportsystem.mapper;

import com.example.transportsystem.dto.client.ClientInputDto;
import com.example.transportsystem.dto.client.ClientOutputDto;
import com.example.transportsystem.model.Client;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {OrderMapper.class})
public interface ClientMapper {
    Client toEntity(ClientInputDto clientOutputDto);

    ClientOutputDto toDto(Client client);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Client partialUpdate(ClientInputDto clientOutputDto, @MappingTarget Client client);
}