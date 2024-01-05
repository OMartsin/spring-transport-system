package com.example.transportsystem.repository;

import com.example.transportsystem.model.driver.DriverLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverLicenseRepository extends JpaRepository<DriverLicense, Long> {
}