package com.fandza.ccs.Fandza.dtos.driver;

import jakarta.validation.constraints.NotBlank;

public record DriverUpdateRequestDTO (

        @NotBlank(message = "Nome é obrigatório")
        String name,
        String phoneNumber
){
}
