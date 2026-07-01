package com.fandza.ccs.Fandza.services;


import com.fandza.ccs.Fandza.dtos.address.AddressRequestDTO;
import com.fandza.ccs.Fandza.dtos.address.AddressResponseDTO;
import com.fandza.ccs.Fandza.dtos.address.AddressUpdateRequestDTO;
import com.fandza.ccs.Fandza.entities.Address;
import com.fandza.ccs.Fandza.exception.ResourceNotFoundException;
import com.fandza.ccs.Fandza.mappers.AddressMapper;
import com.fandza.ccs.Fandza.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressService(
            AddressRepository addressRepository,
            AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public List<AddressResponseDTO> findAllAddresses() {
        List<Address> addresses = addressRepository.findAll();

        return addresses
                .stream()
                .map(addressMapper::toResponse)
                .toList();
    }

    public AddressResponseDTO findAddressById(UUID id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ADDRESS_NOT_FOUND","Endereço não Encontrado"));

        return addressMapper.toResponse(address);
    }


    public AddressResponseDTO createAddress(AddressRequestDTO request) {

        var newAddress = addressMapper.toEntity(request);
        var saved = addressRepository.save(newAddress);
        return addressMapper.toResponse(saved);
    }

    public AddressResponseDTO updateAddress(UUID id, AddressUpdateRequestDTO request) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ADDRESS_NOT_FOUND","Endereço não Encontrado"));

        address.setNeighborhood(request.neighborhood());
        address.setBlock(request.block());
        address.setHouseNumber(request.houseNumber());

        Address saved = addressRepository.save(address);

        return addressMapper.toResponse(saved);
    }

    public void deleteAddress(UUID id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ADDRESS_NOT_FOUND","Endereço não Encontrado"));

        addressRepository.delete(address);
    }




}
