package com.example.transportsystem.dto.trailer;

import com.example.transportsystem.model.transport.trailer.Trailer;

import java.io.Serializable;

/**
 * DTO for {@link Trailer}
 */
public record TrailerInputDto(Long id, String brand, String model, String registrationNumber, Integer weight,
                              Integer capacity, String trailerType) implements Serializable {
}