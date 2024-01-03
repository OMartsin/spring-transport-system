package com.example.transportsystem.model.order;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "delivery_log")
@Data
public class DeliveryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery;

    @Basic(optional = false)
    @Column(nullable = false)
    private String log;

    @Basic(optional = false)
    @Column(nullable = false)
    private Timestamp timestamp;

    @Basic(optional = false)
    @Column(nullable = false)
    private Float latitude;

    @Basic(optional = false)
    @Column(nullable = false)
    private Float longitude;

    @Basic(optional = true)
    @Column(nullable = true)
    private String address;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
