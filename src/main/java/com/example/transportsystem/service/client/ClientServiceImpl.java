package com.example.transportsystem.service.client;

import com.example.transportsystem.dto.client.ClientInputDto;
import com.example.transportsystem.dto.client.ClientOutputDto;
import com.example.transportsystem.mapper.ClientMapper;
import com.example.transportsystem.model.Client;
import com.example.transportsystem.model.User;
import com.example.transportsystem.repository.ClientRepository;
import com.example.transportsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientOutputDto> findAll() {
        return clientRepository.findAll().stream().map(clientMapper::toDto).toList();
    }

    @Override
    public ClientOutputDto findById(Long id) {
        return clientRepository.findById(id).map(clientMapper::toDto).orElseThrow();
    }

    @Override
    public ClientOutputDto save(ClientInputDto client) {
        User user = userRepository.save(new User(client.name(), client.edrpou()));
        Client client1 = clientMapper.toEntity(client);
        client1.setUser(user);
        return clientMapper.toDto(clientRepository.save(client1));
    }

    @Override
    public ClientOutputDto update(ClientInputDto client) {
        if(clientRepository.findById(client.id()).isEmpty()) {
            throw new RuntimeException("Client with id " + client.id() + " not found");
        }
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(client)));
    }

    @Override
    public void deleteById(Long id) {
       clientRepository.deleteById(id);
    }
}
