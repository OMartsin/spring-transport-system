package com.example.transportsystem.service.client;

import com.example.transportsystem.dto.client.ClientInputDto;
import com.example.transportsystem.dto.client.ClientOutputDto;
import com.example.transportsystem.dto.client.ClientOutputListDto;

import java.util.List;

public interface ClientService {
    List<ClientOutputListDto> findAll();
    ClientOutputDto findById(Long id);
    ClientOutputDto save(ClientInputDto client);
    ClientOutputDto update(ClientInputDto client);
    void deleteById(Long id);

}
