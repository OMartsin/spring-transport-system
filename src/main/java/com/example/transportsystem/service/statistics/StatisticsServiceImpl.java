package com.example.transportsystem.service.statistics;

import com.example.transportsystem.dto.statistics.AllStatisticsResponse;
import com.example.transportsystem.dto.statistics.CommonStatisticsResponse;
import com.example.transportsystem.dto.statistics.OrderStatisticsResponse;
import com.example.transportsystem.dto.statistics.ProfitResponse;
import com.example.transportsystem.model.FinanceOperations;
import com.example.transportsystem.model.order.Order;
import com.example.transportsystem.repository.ClientRepository;
import com.example.transportsystem.repository.DriverRepository;
import com.example.transportsystem.repository.FinanceOperationsRepository;
import com.example.transportsystem.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {
    private final FinanceOperationsRepository financeOperationsRepository;
    private final OrderRepository orderRepository;
    private final DriverRepository driverRepository;
    private final ClientRepository clientRepository;

    public ProfitResponse getProfitStatistics(String startDate, String endDate) {
        LocalDateTime startDateTime = getDateFromISO(startDate);
        LocalDateTime endDateTime = getDateFromISO(endDate);

        var operations = financeOperationsRepository.findAllByTimestampBetween(
                Timestamp.valueOf(startDateTime), Timestamp.valueOf(endDateTime));
        operations.sort(Comparator.comparing(FinanceOperations::getTimestamp));
        var profitResponse = new ProfitResponse();

        Map<String, Double> profitByMonth = Arrays.stream(Month.values())
                .collect(Collectors.toMap(
                        Month::name,
                        month -> 0.0,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        Map<String, Double> monthlyProfit = operations.stream()
                .collect(Collectors.groupingBy(
                        operation -> operation.getTimestamp().toLocalDateTime().getMonth().name(),
                        Collectors.summingDouble(FinanceOperations::getAmount)));

        monthlyProfit.forEach((key, value) -> profitByMonth.merge(key, value, (oldVal, newVal) -> newVal));

        profitResponse.setTotalProfit(operations.stream().mapToDouble(FinanceOperations::getAmount).sum());
        profitResponse.setProfit(profitByMonth);

        return profitResponse;
    }

    public OrderStatisticsResponse getOrdersByMonth(String startDate, String endDate) {
        LocalDateTime startDateTime = getDateFromISO(startDate);
        LocalDateTime endDateTime = getDateFromISO(endDate);

        var orders = orderRepository.findAllByDepartureDateBetween(
                Timestamp.valueOf(startDateTime), Timestamp.valueOf(endDateTime));
        var orderStatisticsResponse = new OrderStatisticsResponse();

        orderStatisticsResponse.setTotalOrders(orders.size());

        Map<String, Integer> ordersByMonth = Arrays.stream(Month.values())
                .collect(Collectors.toMap(
                        Enum::name,
                        month -> 0,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        Map<String, Integer> monthlyOrderCounts = orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getDepartureDate().toLocalDateTime().getMonth().name(),
                        Collectors.summingInt(order -> 1)));

        monthlyOrderCounts.forEach((key, value) -> ordersByMonth.merge(key, value, (oldVal, newVal) -> newVal));

        orderStatisticsResponse.setOrdersByMonth(ordersByMonth);

        return orderStatisticsResponse;
    }

    private LocalDateTime getDateFromISO(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return LocalDateTime.parse(date, formatter);
    }

    public CommonStatisticsResponse getCommonStatistics() {
        var commonStatisticsResponse = new CommonStatisticsResponse();
        commonStatisticsResponse.setTotalOrders(orderRepository.count());
        commonStatisticsResponse.setTotalClients(clientRepository.count());
        commonStatisticsResponse.setTotalDrivers(driverRepository.count());
        commonStatisticsResponse.setTotalProfit(financeOperationsRepository.findAll()
                .stream().mapToDouble(FinanceOperations::getAmount).sum());

        return commonStatisticsResponse;
    }

    public AllStatisticsResponse getAllStatistics(String startDate, String endDate) {
        return new AllStatisticsResponse(getCommonStatistics(), getOrdersByMonth(startDate, endDate),
                getProfitStatistics(startDate, endDate));
    }
}
