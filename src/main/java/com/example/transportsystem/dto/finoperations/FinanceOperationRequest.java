package com.example.transportsystem.dto.finoperations;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.example.transportsystem.model.FinanceOperations}
 */
public record FinanceOperationRequest(@NotNull Long id, @NotNull Double amount, @NotNull Timestamp timestamp,
                                      @NotNull @NotEmpty @NotBlank String type,
                                      @NotNull @NotEmpty @NotBlank String name, String description,
                                      Long orderId) implements Serializable {
}