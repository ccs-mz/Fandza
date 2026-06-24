package com.fandza.ccs.Fandza.dtos.driver;

import com.fandza.ccs.Fandza.enums.DriverStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DriverDetailsResponseDTO(
        String drivingLicenseNumber,
        @JsonFormat(shape =  JsonFormat.Shape.STRING , pattern = "dd/MM/yyyy")
        LocalDate licenseIssueDate,
        DriverStatus status,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "Africa/Maputo")
        LocalDateTime statusUploadedAt,

        String statusReason,
        Double averageRating,
        Integer totalAssessments
) {
}
