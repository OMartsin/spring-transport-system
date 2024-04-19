package com.example.transportsystem.dto.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AllStatisticsResponse {
    private CommonStatisticsResponse common;
    private OrderStatisticsResponse orders;
    private ProfitResponse profit;
}
