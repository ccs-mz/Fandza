package com.fandza.ccs.Fandza.controller;

import com.fandza.ccs.Fandza.dtos.legal_guardian.LegalGuardianRequestDTO;
import com.fandza.ccs.Fandza.dtos.legal_guardian.LegalGuardianResponseDTO;
import com.fandza.ccs.Fandza.dtos.legal_guardian.LegalGuardianUpdateRequestDTO;
import com.fandza.ccs.Fandza.services.LegalGuardianService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/guardian")
public class LegalGuardianController {


    private final LegalGuardianService service;

    public LegalGuardianController(LegalGuardianService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<LegalGuardianResponseDTO>> findAll(
    ) {
        return ResponseEntity.ok(service
                .findAllLegalGuardians());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LegalGuardianResponseDTO> findById(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(service
                .findLegalGuardianById(id));
    }

    @PostMapping
    public ResponseEntity<LegalGuardianResponseDTO> newLegalGuardian(
            @Valid @RequestBody LegalGuardianRequestDTO request
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service
                        .createLegalGuardian(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LegalGuardianResponseDTO> updateLegalGuardian(
             @PathVariable UUID id,
             @Valid @RequestBody LegalGuardianUpdateRequestDTO request
    ){
        return  ResponseEntity.ok(service
                .updateLegalGuardian(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLegalGuardian(
            @PathVariable UUID id
    ){
        service.deleteLegalGuardian(id);
        return ResponseEntity.noContent().build();
    }






}
