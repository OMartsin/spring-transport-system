package com.example.transportsystem.repository;

import com.example.transportsystem.model.driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}