package com.fandza.ccs.Fandza.dtos.legal_guardian.student;

import java.util.UUID;

public record StudentSummaryDTO(
        UUID id,
        String name,
        Integer age,
        String grade,
        String schoolName

) {
}
