package com.fandza.ccs.Fandza.dtos.legal_guardian.student;

import com.fandza.ccs.Fandza.entities.Address;
import com.fandza.ccs.Fandza.entities.LegalGuardian;
import com.fandza.ccs.Fandza.entities.School;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record StudentRequestDTO(
        @NotBlank(message = "Nome é obrigatorio")
        String name,

        @NotBlank(message = "Data de Nascimento e obrigatorio")
        LocalDate dateOfbirth,

        @NotBlank(message = "Classe e obrigatorio")
        String grade,

        UUID schoolID,
        UUID addressID

) {
}
