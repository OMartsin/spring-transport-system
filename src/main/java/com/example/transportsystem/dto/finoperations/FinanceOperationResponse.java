package com.example.transportsystem.dto.finoperations;

import com.example.transportsystem.model.FinanceOperations;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link FinanceOperations}
 */
public record FinanceOperationResponse(Long id, Double amount, Timestamp timestamp, String type, String name,
                                       String description, Long orderId, String orderName) implements Serializable {
}