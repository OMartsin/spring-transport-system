package com.example.transportsystem.repository;

import com.example.transportsystem.model.FinanceOperations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface FinanceOperationsRepository extends JpaRepository<FinanceOperations, Long> {
    List<FinanceOperations> findAllByTimestampBetween(Timestamp start, Timestamp end);
}