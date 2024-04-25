package com.example.transportsystem.dto.client;

import java.io.Serializable;

/**
 * DTO for {@link com.example.transportsystem.model.Client}
 */
public record ClientOutputListDto(Long id, String name, String edrpou, String iban) implements Serializable {
}