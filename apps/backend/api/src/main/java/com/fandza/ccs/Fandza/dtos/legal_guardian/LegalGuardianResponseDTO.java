package com.fandza.ccs.Fandza.dtos.legal_guardian;

import com.fandza.ccs.Fandza.dtos.legal_guardian.student.StudentSummaryDTO;
import com.fandza.ccs.Fandza.entities.Student;
import com.fandza.ccs.Fandza.enums.UserType;

import java.util.List;
import java.util.UUID;

public record LegalGuardianResponseDTO(
        UUID id,
        String name,
        String email,
        String phoneNumber,
        UserType userType,
        List<Student> students



) {
}
