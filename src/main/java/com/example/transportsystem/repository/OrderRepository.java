package com.example.transportsystem.repository;

import com.example.transportsystem.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}