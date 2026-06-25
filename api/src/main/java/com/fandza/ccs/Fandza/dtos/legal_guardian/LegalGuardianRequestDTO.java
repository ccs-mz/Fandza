package com.fandza.ccs.Fandza.dtos.legal_guardian;

import com.fandza.ccs.Fandza.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LegalGuardianRequestDTO(
        @NotBlank(message = "Nome é Obrigatório")
        String name,
        @Email(message = "Email Inválido")
        @NotBlank(message = "Email é Obrigatório")
        String email,
        @JsonFormat()
        @NotBlank(message = "Número de Telefone é Obrigatório")
        String phoneNumber,
        @Size(min = 8,message = "Senha deve ter no mínimo 8 caracteres")
        String password,

        UserType userType
) {
}
