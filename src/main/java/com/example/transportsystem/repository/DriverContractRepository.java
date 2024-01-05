package com.example.transportsystem.repository;

import com.example.transportsystem.model.driver.DriverContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverContractRepository extends JpaRepository<DriverContract, Long> {
}