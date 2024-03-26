package com.example.transportsystem.controller;

import com.example.transportsystem.model.User;
import com.example.transportsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    @GetMapping("/user")
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
