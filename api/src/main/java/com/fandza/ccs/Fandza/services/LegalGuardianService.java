package com.fandza.ccs.Fandza.services;


import com.fandza.ccs.Fandza.dtos.legal_guardian.LegalGuardianResponseDTO;
import com.fandza.ccs.Fandza.entities.LegalGuardian;
import com.fandza.ccs.Fandza.exception.ResourceNotFoundException;
import com.fandza.ccs.Fandza.repositories.LegalGuardianRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LegalGuardianService {

    private final LegalGuardianRepository legalGuardianRepository;
    private final LegalGuardian

    public LegalGuardianService(LegalGuardianRepository legalGuardianRepository) {
        this.legalGuardianRepository = legalGuardianRepository;
    }


    public LegalGuardianResponseDTO findLegalGuardianById(UUID id) {

        LegalGuardian guardian = legalGuardianRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DRIVER_NOT_FOUND", "Encarregado não Encontrado"));

        return
    }






}
