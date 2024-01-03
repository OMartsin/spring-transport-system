package com.example.transportsystem.model.transport.truck;

import com.example.transportsystem.model.transport.Transport;
import jakarta.persistence.*;
import lombok.Data;

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
}