package com.fandza.ccs.Fandza.dtos.document;

import com.fandza.ccs.Fandza.enums.DocumentType;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record DriverDocumentRequestDTO(
        @NotBlank(message = "Selecione o Tipo de Documento")
        DocumentType documentType,
        String fileUrl,
        UUID idDriver
) {
}
