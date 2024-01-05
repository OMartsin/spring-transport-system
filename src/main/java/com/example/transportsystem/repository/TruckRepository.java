package com.example.transportsystem.repository;

import com.example.transportsystem.model.transport.truck.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {
}