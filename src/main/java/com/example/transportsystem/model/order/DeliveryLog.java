package com.example.transportsystem.model.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "delivery_log")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery;

    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String description;

    @Basic(optional = false)
    @Column(nullable = false)
    private Timestamp timestamp;

    @Basic(optional = false)
    @Column(nullable = false)
    private Float latitude;

    @Basic(optional = false)
    @Column(nullable = false)
    private Float longitude;

    @Basic
    @Column(length = 128)
    private String address;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
