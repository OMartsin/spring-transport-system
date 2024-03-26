package com.example.transportsystem.model.transport.trailer;

import com.example.transportsystem.model.order.Delivery;
import com.example.transportsystem.model.transport.Transport;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trailer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Trailer extends Transport {
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer capacity;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private TrailerType trailerType;

    @OneToMany(mappedBy = "trailer")
    private Set<Delivery> deliveries = new HashSet<>();

}
