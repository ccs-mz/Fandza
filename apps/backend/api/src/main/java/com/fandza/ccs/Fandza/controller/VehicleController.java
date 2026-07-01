package com.fandza.ccs.Fandza.controller;


import com.fandza.ccs.Fandza.dtos.vehicle.VehicleRequestDTO;
import com.fandza.ccs.Fandza.dtos.vehicle.VehicleResponseDTO;
import com.fandza.ccs.Fandza.dtos.vehicle.VehicleUpdateRequestDTO;
import com.fandza.ccs.Fandza.entities.Vehicle;
import com.fandza.ccs.Fandza.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final VehicleService service;


    public VehicleController(VehicleService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> findAll(){
        return ResponseEntity.ok(service.findAllVehicles());

    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> findById(
            @PathVariable UUID id){
        return ResponseEntity.ok(service.findVehicleById(id));
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> newVehicle(
            @Valid @RequestBody VehicleRequestDTO request
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createVehicle(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> updateVehicle(
            @PathVariable UUID id,
            @Valid @RequestBody VehicleUpdateRequestDTO request
    ){
        return ResponseEntity.ok(service.updateVehicle(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVehicle(
            @PathVariable UUID id
    ){
        service.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }



}
