package com.example.transportsystem.repository;

import com.example.transportsystem.model.order.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}