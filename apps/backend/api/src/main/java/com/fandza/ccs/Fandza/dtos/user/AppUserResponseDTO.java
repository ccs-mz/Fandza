package com.fandza.ccs.Fandza.dtos.user;

import com.fandza.ccs.Fandza.enums.UserType;

import java.util.UUID;

public record AppUserResponseDTO(
        UUID id,
        String name,
        String email,
        String phoneNumber,
        UserType userType

) {
}
