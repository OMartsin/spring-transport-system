package com.example.transportsystem.mapper;

import com.example.transportsystem.model.transport.trailer.Trailer;
import com.example.transportsystem.dto.trailer.TrailerInputDto;
import com.example.transportsystem.dto.trailer.TrailerOutputDto;
import com.example.transportsystem.model.transport.trailer.TrailerType;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
    uses = {DeliveryMapper.class})
public interface TrailerMapper {
    @Mapping(target = "trailerType", expression = "java(trailerTypeMapping(trailerInputDto.trailerType()))")
    Trailer toEntity(TrailerInputDto trailerInputDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Trailer partialUpdate(TrailerInputDto trailerInputDto, @MappingTarget Trailer trailer);

    @Mapping(target = "trailerType", expression = "java(trailerTypeMappingToString(trailer.getTrailerType()))")
    TrailerOutputDto toDto(Trailer trailer);

    default TrailerType trailerTypeMapping(String trailerType) {
        return TrailerType.valueOf(trailerType);
    }

    default String trailerTypeMappingToString(TrailerType trailerType) {
        return trailerType.getName();
    }

}
