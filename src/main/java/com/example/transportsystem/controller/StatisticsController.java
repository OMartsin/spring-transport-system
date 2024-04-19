package com.example.transportsystem.controller;

import com.example.transportsystem.dto.statistics.AllStatisticsResponse;
import com.example.transportsystem.dto.statistics.CommonStatisticsResponse;
import com.example.transportsystem.dto.statistics.OrderStatisticsResponse;
import com.example.transportsystem.dto.statistics.ProfitResponse;
import com.example.transportsystem.service.statistics.StatisticsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;

    @GetMapping("/profit")
    public ResponseEntity<ProfitResponse> getProfit(@RequestParam String startDate, @RequestParam String endDate){
        return ResponseEntity.ok(statisticsService.getProfitStatistics(startDate, endDate));
    }

    @GetMapping("/ordersByMonth")
    public ResponseEntity<OrderStatisticsResponse> getOrdersByMonth
            (@RequestParam String startDate, @RequestParam String endDate){
        return ResponseEntity.ok(statisticsService.getOrdersByMonth(startDate, endDate));
    }

    @GetMapping("/common")
    public ResponseEntity<CommonStatisticsResponse> getCommonStatistics(){
        return ResponseEntity.ok(statisticsService.getCommonStatistics());
    }

    @GetMapping("/all")
    public ResponseEntity<AllStatisticsResponse> getAllStatistics
            (@RequestParam String startDate, @RequestParam String endDate){
        return ResponseEntity.ok(statisticsService.getAllStatistics(startDate, endDate));
    }
}
