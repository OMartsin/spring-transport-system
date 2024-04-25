package com.example.transportsystem.service.trailer;

import com.example.transportsystem.dto.trailer.TrailerInputDto;
import com.example.transportsystem.dto.trailer.TrailerOutputDto;
import com.example.transportsystem.dto.trailer.TrailerOutputListDto;
import com.example.transportsystem.mapper.TrailerMapper;
import com.example.transportsystem.repository.TrailerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrailerServiceImpl implements TrailerService {
    private final TrailerRepository trailerRepository;
    private final TrailerMapper trailerMapper;

    public List<TrailerOutputListDto> findAll(){
        return trailerRepository.findAll().stream().map(trailerMapper::toListDto).toList();
    }

    public TrailerOutputDto findById(Long id){
        return trailerMapper.toDto(trailerRepository.findById(id).orElseThrow());
    }

    public TrailerOutputDto save(TrailerInputDto trailer){
        return trailerMapper.toDto(trailerRepository.save(trailerMapper.toEntity(trailer)));
    }

    public TrailerOutputDto update(TrailerInputDto trailer){
        return trailerMapper.toDto(trailerRepository.save(trailerMapper.toEntity(trailer)));
    }

    public void deleteById(Long id){
        trailerRepository.deleteById(id);
    }
}
