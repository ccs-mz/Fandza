package com.fandza.ccs.Fandza.dtos.driver;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DriverDetailsRequestDTO(

        @NotBlank(message = "O número da carta de condução é obrigatório")
        String drivingLicenseNumber,

        @NotBlank(message = "A data de emissão da carta é obrigatória")
        LocalDate licenseIssueDate


) {
}
