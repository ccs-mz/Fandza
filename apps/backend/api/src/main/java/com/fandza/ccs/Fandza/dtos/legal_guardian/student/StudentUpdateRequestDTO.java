package com.fandza.ccs.Fandza.dtos.legal_guardian.student;

import jakarta.validation.constraints.NotBlank;

public record StudentUpdateRequestDTO(
        @NotBlank(message = "Nome e obrigatorio")
        String name,
        String grade
) {
}
