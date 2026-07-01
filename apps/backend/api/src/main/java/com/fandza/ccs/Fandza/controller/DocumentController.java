package com.fandza.ccs.Fandza.controller;


import com.fandza.ccs.Fandza.dtos.document.DocumentResponseDTO;
import com.fandza.ccs.Fandza.dtos.document.DriverDocumentRequestDTO;
import com.fandza.ccs.Fandza.dtos.document.VehicleDocumentRequestDTO;
import com.fandza.ccs.Fandza.dtos.vehicle.VehicleRequestDTO;
import com.fandza.ccs.Fandza.dtos.vehicle.VehicleResponseDTO;
import com.fandza.ccs.Fandza.services.DocumentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    private final DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }

    @PostMapping("/driver/{id}")
    private ResponseEntity<DocumentResponseDTO> uploadforDriver(
            @PathVariable UUID id,
           @Valid @RequestBody DriverDocumentRequestDTO request
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.uploadDriverDocument(id, request));

    }

    @PostMapping ResponseEntity<DocumentResponseDTO> uploadforVehicle(
            @PathVariable UUID id,
            @Valid @RequestBody VehicleDocumentRequestDTO request
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.uploadVehicleDocument(id, request));
    }



}
