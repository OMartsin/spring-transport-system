package com.example.transportsystem.model.transport;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String brand;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String model;

    @Basic(optional = false)
    @Column(nullable = false, length = 16, unique = true)
    private String registrationNumber;

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer weight;
}