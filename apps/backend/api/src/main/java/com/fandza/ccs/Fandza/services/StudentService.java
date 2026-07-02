package com.fandza.ccs.Fandza.services;


import com.fandza.ccs.Fandza.dtos.legal_guardian.student.StudentRequestDTO;
import com.fandza.ccs.Fandza.dtos.legal_guardian.student.StudentResponseDTO;
import com.fandza.ccs.Fandza.dtos.legal_guardian.student.StudentUpdateRequestDTO;
import com.fandza.ccs.Fandza.entities.Address;
import com.fandza.ccs.Fandza.entities.LegalGuardian;
import com.fandza.ccs.Fandza.entities.School;
import com.fandza.ccs.Fandza.entities.Student;
import com.fandza.ccs.Fandza.exception.ResourceNotFoundException;
import com.fandza.ccs.Fandza.mappers.StudentMapper;
import com.fandza.ccs.Fandza.repositories.AddressRepository;
import com.fandza.ccs.Fandza.repositories.LegalGuardianRepository;
import com.fandza.ccs.Fandza.repositories.SchoolRepository;
import com.fandza.ccs.Fandza.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final LegalGuardianRepository legalGuardianRepository;
    private final StudentMapper studentMapper;
    private final AddressRepository addressRepository;
    private final SchoolRepository schoolRepository;


    public StudentService(StudentRepository studentRepository,
                          StudentMapper studentMapper,
                          LegalGuardianRepository legalGuardianRepository,
                          AddressRepository addressRepository,
                          SchoolRepository schoolRepository
                          ) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.legalGuardianRepository = legalGuardianRepository;
        this.schoolRepository = schoolRepository;
        this.addressRepository = addressRepository;
    }

    public List<StudentResponseDTO> findAllStudents(){
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponse)
                .toList();
    }


    public StudentResponseDTO findStudentById(UUID id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("STUDENT_NOT_FOUND", "Aluno não Encontrado"));

        return studentMapper.toResponse(student);
    }



    public StudentResponseDTO newStudent(UUID legalGuardianId, StudentRequestDTO request) {

        LegalGuardian guardian = legalGuardianRepository.findById(legalGuardianId)
                .orElseThrow(() -> new
                        ResourceNotFoundException("LEGAL_GUARDIAN_NOT_FOUND", "Encarregado não Encontrado"));

        School school = null;
        if (request.schoolID() != null) {
            school = schoolRepository.findById(request.schoolID())
                    .orElseThrow(() -> new ResourceNotFoundException("SCHOOL_NOT_FOUND", "Escola não Encontrada"));
        }

        Address address = null;
        if (request.addressID() != null) {
            address = addressRepository.findById(request.addressID())
                    .orElseThrow(() -> new ResourceNotFoundException("ADDRESS_NOT_FOUND", "Endereço não Encontrado"));
        }

        Student student = new Student(
                request.name(),
                request.dateOfbirth(),
                guardian
        );

        if (school != null) {
            student.setSchool(school);
        }
        if (address != null) {
            student.setAddress(address);
        }

        Student saved = studentRepository.save(student);

        return  studentMapper.toResponse(saved);
    }

    public StudentResponseDTO updateStudent(UUID id, StudentUpdateRequestDTO request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("STUDENT_NOT_FOUND", "Aluno não Encontrado"));

        student.setName(request.name());
        student.setGrade(request.grade());

        Student saved =  studentRepository.save(student);

        return studentMapper.toResponse(saved);
    }

    public void deleteStudent(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("STUDENT_NOT_FOUND", "Aluno não Encontrado"));

        studentRepository.delete(student);
    }


}
