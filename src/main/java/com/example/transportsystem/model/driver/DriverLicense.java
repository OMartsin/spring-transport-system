package com.example.transportsystem.model.driver;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "driver_license")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 16, unique = true)
    private String number;

    @Basic(optional = false)
    @Column(nullable = false)
    private Date issueDate;

    private Date expirationDate;

    @ManyToOne
    private Driver driver;

    @ManyToMany
    @JoinTable(name = "driver_license_category_driverLicenses",
            joinColumns = @JoinColumn(name = "driverLicenseCategory_id"))
    private Set<DriverLicenseCategory> categories = new HashSet<>();

}
