package com.example.transportsystem.service.client;

import com.example.transportsystem.dto.client.ClientInputDto;
import com.example.transportsystem.dto.client.ClientOutputDto;

import java.util.List;

public interface ClientService {
    List<ClientOutputDto> findAll();
    ClientOutputDto findById(Long id);
    ClientOutputDto save(ClientInputDto client);
    ClientOutputDto update(ClientInputDto client);
    void deleteById(Long id);

}
