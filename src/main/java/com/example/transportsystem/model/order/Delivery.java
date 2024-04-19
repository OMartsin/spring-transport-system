package com.example.transportsystem.model.order;

import com.example.transportsystem.model.driver.Driver;
import com.example.transportsystem.model.transport.trailer.Trailer;
import com.example.transportsystem.model.transport.truck.Truck;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trailer_id", nullable = false)
    private Trailer trailer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "truck_id", nullable = false)
    private Truck truck;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @OneToMany(mappedBy = "delivery")
    private List<DeliveryLog> deliveryLogs;

}