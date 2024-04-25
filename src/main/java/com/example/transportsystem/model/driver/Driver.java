package com.example.transportsystem.model.driver;

import com.example.transportsystem.model.User;
import com.example.transportsystem.model.order.Delivery;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "driver")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Column(length = 64)
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

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "driver")
    private Set<Delivery> deliveries = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id")
    private Set<DriverContract> driverContract = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Set<DriverLicense> driverLicenses = new HashSet<>();

    public String getFullName() {
        return name + " " + surname + " " + patronymic + " " + passportNumber;
    }

}
