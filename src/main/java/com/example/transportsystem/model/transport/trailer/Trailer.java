package com.example.transportsystem.model.transport.trailer;

import com.example.transportsystem.model.transport.Transport;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "trailer")
@Data
public class Trailer extends Transport {
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer capacity;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private TrailerType trailerType;

}
