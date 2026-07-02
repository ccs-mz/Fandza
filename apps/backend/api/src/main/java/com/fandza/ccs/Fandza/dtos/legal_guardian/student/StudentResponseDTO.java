package com.fandza.ccs.Fandza.dtos.legal_guardian.student;

import java.time.LocalDate;
import java.util.UUID;

public record StudentResponseDTO(
        UUID id,
        String name,
        LocalDate dateOfBirth,
        String grade,
        UUID guardianID,
        String schoolName,
        String addressNeighbohood,
        String addressBlock,
        String addressHouseNr
) {
}
