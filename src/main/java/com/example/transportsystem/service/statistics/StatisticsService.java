package com.example.transportsystem.service.statistics;

import com.example.transportsystem.dto.statistics.AllStatisticsResponse;
import com.example.transportsystem.dto.statistics.CommonStatisticsResponse;
import com.example.transportsystem.dto.statistics.OrderStatisticsResponse;
import com.example.transportsystem.dto.statistics.ProfitResponse;

public interface StatisticsService {
    ProfitResponse getProfitStatistics(String startDate, String endDate);
    OrderStatisticsResponse getOrdersByMonth(String startDate, String endDate);
    CommonStatisticsResponse getCommonStatistics();
    AllStatisticsResponse getAllStatistics(String startDate, String endDate);
}
