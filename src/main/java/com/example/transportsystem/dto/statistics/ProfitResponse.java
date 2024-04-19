package com.example.transportsystem.dto.statistics;

import lombok.Data;

import java.util.Map;

@Data
public class ProfitResponse {
    private Double totalProfit;
    private Map<String, Double> profit;
}
