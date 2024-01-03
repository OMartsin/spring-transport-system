package com.example.transportsystem.model.transport.truck;

public enum FuelType {
    DIESEL("Дизель"),
    PETROL("Бензин");

    private final String name;

    FuelType(String name) {
        this.name = name;
    }
}
