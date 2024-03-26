package com.example.transportsystem.model.transport.truck;

import com.example.transportsystem.model.order.Delivery;
import com.example.transportsystem.model.transport.Transport;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "truck")
@Data
public class Truck extends Transport {
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer euroStandard;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @OneToMany(mappedBy = "truck")
    private Set<Delivery> deliveries = new HashSet<>();
}
