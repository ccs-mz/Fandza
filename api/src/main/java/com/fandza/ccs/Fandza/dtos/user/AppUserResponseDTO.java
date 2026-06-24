package com.fandza.ccs.Fandza.dtos.user;

import com.fandza.ccs.Fandza.enums.UserType;

public record AppUserResponseDTO(

        String name,
        String email,
        String phoneNumber,
        UserType userType

) {
}
