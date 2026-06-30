package com.fandza.ccs.Fandza.dtos.address;

public record AddressUpdateRequestDTO(
        String neighborhood,
        String block,
        String houseNumber
) {
}
