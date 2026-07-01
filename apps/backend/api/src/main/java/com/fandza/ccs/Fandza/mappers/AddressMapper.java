package com.fandza.ccs.Fandza.mappers;

import com.fandza.ccs.Fandza.dtos.address.AddressRequestDTO;
import com.fandza.ccs.Fandza.dtos.address.AddressResponseDTO;
import com.fandza.ccs.Fandza.entities.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {



    public Address toEntity(AddressRequestDTO request){
        Address address = new Address(
                request.neighborhood(),
                request.block(),
                request.houseNumber()


        );
        return address;
    }

    public AddressResponseDTO toResponse(Address address){
        return new AddressResponseDTO(
                address.getIdAddress(),
                address.getHouseNumber(),
                address.getBlock(),
                address.getNeighborhood()
        );
    }
}
