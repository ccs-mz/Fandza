package com.fandza.ccs.Fandza.dtos.address;

import java.util.UUID;

public record AddressResponseDTO(
        UUID id,
        String neighborhood,
        String block,
        String houseNumber
) {
}
