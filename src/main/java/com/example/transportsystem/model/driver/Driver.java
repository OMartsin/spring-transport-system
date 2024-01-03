package com.example.transportsystem.model.driver;

import com.example.transportsystem.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "driver")
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String surname;

    @Basic(optional = true)
    @Column(nullable = true, length = 64)
    private String patronymic;

    @Basic(optional = false)
    @Column(nullable = false, length = 16, unique = true)
    private String passportNumber;

    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String nationality;

    @Basic(optional = false)
    @Column(nullable = false, length = 16, unique = true)
    private String phoneNumber;

    @Basic(optional = false)
    @Column(nullable = false, length = 16, unique = true)
    private String ipn;

    @Basic(optional = false)
    @Column(nullable = false)
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private DriverContract driverContract;

}
