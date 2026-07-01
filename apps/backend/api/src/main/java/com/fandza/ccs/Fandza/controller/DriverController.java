package com.fandza.ccs.Fandza.controller;

import com.fandza.ccs.Fandza.dtos.driver.DriverRequestDTO;
import com.fandza.ccs.Fandza.dtos.driver.DriverResponseDTO;
import com.fandza.ccs.Fandza.dtos.driver.DriverUpdateRequestDTO;
import com.fandza.ccs.Fandza.mappers.DriverMapper;
import com.fandza.ccs.Fandza.services.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;

    }

    @GetMapping
    public ResponseEntity<List<DriverResponseDTO>> findAll(){
        return ResponseEntity.ok(service.findAllDrivers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverResponseDTO> findById(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(service.findDriverById(id));
    }


    @PostMapping
    public ResponseEntity<DriverResponseDTO> newDriver(
           @Valid@RequestBody DriverRequestDTO request
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createDriver(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverResponseDTO> updateDriver(
            @PathVariable UUID id,
            @Valid  @RequestBody DriverUpdateRequestDTO request
    ){
        return ResponseEntity.ok(service.updateDriver(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(
            @PathVariable UUID id
    ){
        service.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }







}
