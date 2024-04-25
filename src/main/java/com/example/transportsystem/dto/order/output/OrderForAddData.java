package com.example.transportsystem.dto.order.output;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class OrderForAddData {
    List<IdName> trailers;
    List<IdName> trucks;
    List<IdName> drivers;
    List<IdName> clients;

    @Data
    @AllArgsConstructor
    public static class IdName {
        private Long id;
        private String name;

    }
}
