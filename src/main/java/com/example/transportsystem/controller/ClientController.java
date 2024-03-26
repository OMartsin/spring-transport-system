package com.example.transportsystem.controller;

import com.example.transportsystem.dto.client.ClientInputDto;
import com.example.transportsystem.dto.client.ClientOutputDto;
import com.example.transportsystem.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<ClientOutputDto> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientOutputDto findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public ClientOutputDto create(@RequestBody ClientInputDto client) {
        return clientService.save(client);
    }

    @PutMapping
    public ClientOutputDto update(@RequestBody ClientInputDto client) {
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
