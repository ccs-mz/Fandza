package com.fandza.ccs.Fandza.mappers;


import com.fandza.ccs.Fandza.dtos.legal_guardian.student.StudentRequestDTO;
import com.fandza.ccs.Fandza.dtos.legal_guardian.student.StudentResponseDTO;
import com.fandza.ccs.Fandza.entities.LegalGuardian;
import com.fandza.ccs.Fandza.entities.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentResponseDTO toResponse(Student student) {
        return new  StudentResponseDTO(
                student.getIdStudent(),
                student.getName(),
                student.getDateOfBirth(),
                student.getGrade(),
                student.getLegalGuardian().getIdUser(),
                student.getSchool() != null ? student.getName(): null,
                student.getAddress() != null ? student.getAddress().getNeighborhood() : null,
                student.getAddress() != null ? student.getAddress().getBlock(): null,
                student.getAddress() != null ? student.getAddress().getHouseNumber() : null
        );
    }
}
