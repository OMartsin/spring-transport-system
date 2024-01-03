package com.example.transportsystem.model.order;

public enum DeliveryStatus {
    PENDING("Очікує на виконання"),
    IN_PROGRESS("Виконується"),
    COMPLETED("Виконано"),
    CANCELLED("Скасовано");

    private final String status;

    DeliveryStatus(String status) {
        this.status = status;
    }
}
