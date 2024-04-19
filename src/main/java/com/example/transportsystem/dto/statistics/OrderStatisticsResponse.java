package com.example.transportsystem.dto.statistics;

import lombok.Data;

import java.util.Map;

@Data
public class OrderStatisticsResponse {
    private Integer totalOrders;
    private Map<String, Integer> ordersByMonth;
}
