package com.example.transportsystem.dto.client;

import java.io.Serializable;

/**
 * DTO for {@link com.example.transportsystem.model.Client}
 */
public record ClientInputDto(Long id, String name, String address, String edrpou, String ipn, String iban, String bank,
                             String mfo) implements Serializable {
}