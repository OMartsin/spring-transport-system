package com.example.transportsystem.dto.trailer;

import java.io.Serializable;

/**
 * DTO for {@link com.example.transportsystem.model.transport.trailer.Trailer}
 */
public record TrailerOutputListDto(Long id, String brand, String model, String registrationNumber,
                                   Integer weight) implements Serializable {
}