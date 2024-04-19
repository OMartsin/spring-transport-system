package com.example.transportsystem.dto.statistics;

import lombok.Data;

@Data
public class CommonStatisticsResponse {
    private Long totalOrders;
    private Long totalDrivers;
    private Long totalClients;
    private Double totalProfit;


}
