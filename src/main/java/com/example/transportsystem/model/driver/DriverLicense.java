package com.example.transportsystem.model.driver;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "driver_license")
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

    @Basic(optional = true)
    @Column(nullable = true)
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToMany
    @JoinTable(
        name = "driver_license_category",
        joinColumns = @JoinColumn(name = "driver_license_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

}
