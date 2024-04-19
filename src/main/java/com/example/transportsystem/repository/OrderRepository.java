package com.example.transportsystem.repository;

import com.example.transportsystem.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByDepartureDateBetween(Timestamp start, Timestamp end);
}