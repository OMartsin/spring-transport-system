package com.example.transportsystem.service.truck;

import com.example.transportsystem.dto.truck.TruckInputDto;
import com.example.transportsystem.dto.truck.TruckOutputDto;
import com.example.transportsystem.mapper.TruckMapper;
import com.example.transportsystem.repository.TruckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TruckServiceImpl implements TruckService {
    private final TruckRepository truckRepository;
    private final TruckMapper truckMapper;

    public List<TruckOutputDto> findAll(){
        return truckRepository.findAll().stream().map(truckMapper::toDto).toList();
    }

    public TruckOutputDto findById(Long id){
        return truckMapper.toDto(truckRepository.findById(id).orElseThrow());
    }

    public TruckOutputDto save(TruckInputDto truck){
        return truckMapper.toDto(truckRepository.save(truckMapper.toEntity(truck)));
    }

    public TruckOutputDto update(TruckInputDto truck){
        return truckMapper.toDto(truckRepository.save(truckMapper.toEntity(truck)));
    }

    public void deleteById(Long id){
        truckRepository.deleteById(id);
    }

}
