package com.example.transportsystem.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.transportsystem.model.User}
 */
public record UserDto(String login, String password) implements Serializable {
}