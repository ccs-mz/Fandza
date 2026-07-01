package com.fandza.ccs.Fandza.dtos.driver;

import com.fandza.ccs.Fandza.enums.UserType;

import java.util.UUID;

public record DriverResponseDTO(
        UUID id,
        String name,
        String email,
        String phoneNumber,
        UserType userType,
        DriverDetailsResponseDTO driverDetailsResponseDTO
) {
}
