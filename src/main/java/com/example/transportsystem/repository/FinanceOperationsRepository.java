package com.example.transportsystem.repository;

import com.example.transportsystem.model.FinanceOperations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceOperationsRepository extends JpaRepository<FinanceOperations, Long> {
}