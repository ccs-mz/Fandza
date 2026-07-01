package com.fandza.ccs.Fandza.dtos.vehicle;

import java.util.UUID;

public record VehicleResponseDTO(
        UUID id,
        String vehicleLicensePlate,
        String brand,
        String model,
        String color,
        Integer capacity
) {
}
