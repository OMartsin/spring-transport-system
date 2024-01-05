package com.example.transportsystem.model.driver;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "driver_license_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverLicenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 8, unique = true)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false, length = 32, unique = true)
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<DriverLicense> driverLicenses = new LinkedHashSet<>();

}
