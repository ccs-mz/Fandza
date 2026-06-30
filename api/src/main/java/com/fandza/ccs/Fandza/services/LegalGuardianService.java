package com.fandza.ccs.Fandza.services;


import com.fandza.ccs.Fandza.dtos.legal_guardian.LegalGuardianRequestDTO;
import com.fandza.ccs.Fandza.dtos.legal_guardian.LegalGuardianResponseDTO;
import com.fandza.ccs.Fandza.dtos.legal_guardian.LegalGuardianUpdateRequestDTO;
import com.fandza.ccs.Fandza.entities.LegalGuardian;
import com.fandza.ccs.Fandza.exception.ResourceNotFoundException;
import com.fandza.ccs.Fandza.mappers.LegalGuardianMapper;
import com.fandza.ccs.Fandza.repositories.LegalGuardianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LegalGuardianService {

    private final LegalGuardianRepository legalGuardianRepository;
    private final LegalGuardianMapper legalGuardianMapper;

    public LegalGuardianService(
            LegalGuardianRepository legalGuardianRepository,
            LegalGuardianMapper legalGuardianMapper) {
        this.legalGuardianRepository = legalGuardianRepository;
        this.legalGuardianMapper = legalGuardianMapper;
    }



    public LegalGuardianResponseDTO findLegalGuardianById(UUID id) {

        LegalGuardian guardian = legalGuardianRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LEGAL_GUARDIAN_NOT_FOUND", "Encarregado não Encontrado"));

        return legalGuardianMapper.toResponse(guardian);
    }

    public List<LegalGuardianResponseDTO> findAllLegalGuardians(){
        List<LegalGuardian> legalGuardians = legalGuardianRepository.findAll();

        return legalGuardians.stream()
                .map(legalGuardianMapper::toResponse)
                .toList();

    }


    public LegalGuardianResponseDTO createLegalGuardian(LegalGuardianRequestDTO legalGuardianRequestDTO){

        var newGuardian =  legalGuardianMapper.toEntity(legalGuardianRequestDTO);
        var savedGuardian = legalGuardianRepository.save(newGuardian);
        return legalGuardianMapper.toResponse(savedGuardian);

    }

    public LegalGuardianResponseDTO updateLegalGuardian(
            UUID id,
            LegalGuardianUpdateRequestDTO request
    ){
        LegalGuardian guardian = legalGuardianRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("LEGAL_GUARDIAN_NOT_FOUND", "Encarregado não Encontrado"));

        guardian.setName(request.name());
        guardian.setPhoneNumber(request.phoneNumber());

        var saved = legalGuardianRepository.save(guardian);

        return legalGuardianMapper.toResponse(saved);
    }






}
