package com.fandza.ccs.Fandza.dtos.vehicle;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record VehicleRequestDTO(
        @NotBlank(message = "Por favor registre a matricula do veiculo")
        String vehicleLicensePlate,
        @NotBlank(message = "Por favor insira a marca do veiculo")
        String brand,
        @NotBlank(message = "Por favor insira o modelo do veiculo")
        String model,
        @NotBlank(message = "Por favor insira a cor do veiculo")
        String color,
        @NotBlank(message = "Por favor registre a capacidade de estudantes do veiculo")
        Integer capacity,
        UUID driverId

) {
}
