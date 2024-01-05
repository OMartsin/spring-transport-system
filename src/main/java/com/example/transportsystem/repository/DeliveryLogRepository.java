package com.example.transportsystem.repository;

import com.example.transportsystem.model.order.DeliveryLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryLogRepository extends JpaRepository<DeliveryLog, Long> {
}