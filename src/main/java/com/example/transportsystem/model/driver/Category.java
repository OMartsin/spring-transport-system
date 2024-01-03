package com.example.transportsystem.model.driver;

import jakarta.persistence.*;

@Entity
@Table(name = "license_category")
public class Category {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 8, unique = true)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false, length = 32, unique = true)
    private String description;

}
