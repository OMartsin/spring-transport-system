package com.example.transportsystem.dto.truck;

import com.example.transportsystem.model.transport.truck.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TruckInputDto implements Serializable {
    private Long id;
    private String brand;
    private String model;
    private String registrationNumber;
    private Integer weight;
    private Integer euroStandard;
    private FuelType fuelType;
}