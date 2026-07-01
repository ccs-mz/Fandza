package com.fandza.ccs.Fandza.mappers;


import com.fandza.ccs.Fandza.dtos.legal_guardian.LegalGuardianRequestDTO;
import com.fandza.ccs.Fandza.dtos.legal_guardian.LegalGuardianResponseDTO;
import com.fandza.ccs.Fandza.entities.LegalGuardian;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LegalGuardianMapper {

    private final PasswordEncoder encoder;

    public LegalGuardianMapper(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public LegalGuardian toEntity(LegalGuardianRequestDTO request){

        String encodedPassword = encoder.encode(request.password());

        LegalGuardian legalGuardian = new LegalGuardian();

        legalGuardian.setName(request.name());
        legalGuardian.setEmail(request.email());
        legalGuardian.setPhoneNumber(request.phoneNumber());
        legalGuardian.setPassword(encodedPassword);
        legalGuardian.setUserType(request.userType());

        return legalGuardian;
    }


    public LegalGuardianResponseDTO toResponse(LegalGuardian guardian){
        return new LegalGuardianResponseDTO(
                guardian.getIdUser(),
                guardian.getName(),
                guardian.getEmail(),
                guardian.getPhoneNumber(),
                guardian.getUserType(),
                guardian.getStudents()

        );
    }
}
