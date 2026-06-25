package com.fandza.ccs.Fandza.dtos.document;

import com.fandza.ccs.Fandza.enums.DocumentStatus;
import com.fandza.ccs.Fandza.enums.DocumentType;

import java.time.LocalDateTime;
import java.util.UUID;

public record DocumentResponseDTO(
        UUID id,
        DocumentType documentType,
        String fileUrl,
        DocumentStatus status,
        LocalDateTime uploadedAt,
        String rejectionReason,

        LocalDateTime reviewedAt
){
}
