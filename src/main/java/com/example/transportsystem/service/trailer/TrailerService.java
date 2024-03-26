package com.example.transportsystem.service.trailer;

import com.example.transportsystem.dto.trailer.TrailerInputDto;
import com.example.transportsystem.dto.trailer.TrailerOutputDto;

import java.util.List;

public interface TrailerService {
    List<TrailerOutputDto> findAll();
    TrailerOutputDto findById(Long id);
    TrailerOutputDto save(TrailerInputDto trailer);
    TrailerOutputDto update(TrailerInputDto trailer);
    void deleteById(Long id);
}
