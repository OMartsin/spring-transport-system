package com.example.transportsystem.model.order;

import com.example.transportsystem.model.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Currency;
import java.util.List;

@Entity
@Table(name = "del_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Basic(optional = false)
    @Column(nullable = false)
    private Double price;

    @Basic(optional = false)
    @Column(nullable = false)
    private Timestamp departureDate;

    @OneToMany(mappedBy = "order")
    private List<Delivery> deliveries;

}
