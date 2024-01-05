package com.example.transportsystem.repository;

import com.example.transportsystem.model.driver.DriverLicenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DriverLicenseCategoryRepository extends JpaRepository<DriverLicenseCategory, Long> {
    DriverLicenseCategory findByName(String name);
    Set<DriverLicenseCategory> findByNameIn(Set<String> categoryNames);

}