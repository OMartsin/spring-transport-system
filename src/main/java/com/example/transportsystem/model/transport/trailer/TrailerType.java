package com.example.transportsystem.model.transport.trailer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrailerType {
    TENT("Тент"),
    REFRIGERATOR("Рефрижератор"),
    CONTAINER("Контейнер"),
    PLATFORM("Платформа"),
    TANK("Цистерна"),
    DUMP("Самосвал"),
    LOWBED("Низькорамник");

    private final String name;
}
