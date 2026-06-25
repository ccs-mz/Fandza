package com.fandza.ccs.Fandza.dtos.vehicle;

import com.fandza.ccs.Fandza.enums.DocumentType;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record VehicleDocumentRequestDTO(
        @NotBlank(message = "Selecione o Tipo de Documento")
        DocumentType documentType,
        String fileUrl,
        UUID idVehicle
) {
}
