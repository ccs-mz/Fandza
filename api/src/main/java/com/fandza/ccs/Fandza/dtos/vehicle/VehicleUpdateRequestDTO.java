package com.fandza.ccs.Fandza.dtos.vehicle;

public record VehicleUpdateRequestDTO(
        String brand,
        String model,
        String color,
        Integer capacity
) {
}
