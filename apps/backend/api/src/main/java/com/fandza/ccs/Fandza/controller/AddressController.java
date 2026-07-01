package com.fandza.ccs.Fandza.controller;


import com.fandza.ccs.Fandza.dtos.address.AddressRequestDTO;
import com.fandza.ccs.Fandza.dtos.address.AddressResponseDTO;
import com.fandza.ccs.Fandza.dtos.address.AddressUpdateRequestDTO;
import com.fandza.ccs.Fandza.services.AddressService;
import com.fandza.ccs.Fandza.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AddressResponseDTO>> findAll(){
        return ResponseEntity.ok(service.findAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> findById(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(service.findAddressById(id));
    }

    @PostMapping
    public ResponseEntity<AddressResponseDTO> newAddress(
            @Valid @RequestBody AddressRequestDTO request
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createAddress(request));
    }


    @PutMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> updateAddress(
            @PathVariable UUID id,
            @Valid @RequestBody AddressUpdateRequestDTO request
    ){
        return ResponseEntity.ok(service.updateAddress(id,request));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(
            @PathVariable UUID id
    ){
        service.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }





}
