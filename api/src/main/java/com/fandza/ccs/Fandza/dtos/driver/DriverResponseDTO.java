package com.fandza.ccs.Fandza.dtos.driver;

import com.fandza.ccs.Fandza.enums.UserType;

public record DriverResponseDTO(
    String name,
    String email,
    String phoneNumber,
    UserType userType,
    DriverDetailsRequestDTO driverDetailsRequestDTO
) {
}
