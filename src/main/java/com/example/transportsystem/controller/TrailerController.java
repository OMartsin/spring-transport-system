package com.example.transportsystem.controller;

import com.example.transportsystem.dto.trailer.TrailerInputDto;
import com.example.transportsystem.dto.trailer.TrailerOutputDto;
import com.example.transportsystem.dto.trailer.TrailerOutputListDto;
import com.example.transportsystem.service.trailer.TrailerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trailer")
@RequiredArgsConstructor
public class TrailerController {
    private final TrailerService trailerService;

    @GetMapping
    public List<TrailerOutputListDto> findAll() {
        return trailerService.findAll();
    }

    @GetMapping("/{id}")
    public TrailerOutputDto findById(@PathVariable Long id) {
        return trailerService.findById(id);
    }

    @PostMapping
    public TrailerOutputDto create(@RequestBody TrailerInputDto trailer) {
        return trailerService.save(trailer);
    }

    @PutMapping
    public TrailerOutputDto update(@RequestBody TrailerInputDto trailer) {
        return trailerService.update(trailer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        trailerService.deleteById(id);
    }
}
