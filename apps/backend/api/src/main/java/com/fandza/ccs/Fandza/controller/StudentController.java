package com.fandza.ccs.Fandza.controller;


import com.fandza.ccs.Fandza.dtos.legal_guardian.student.StudentRequestDTO;
import com.fandza.ccs.Fandza.dtos.legal_guardian.student.StudentResponseDTO;
import com.fandza.ccs.Fandza.dtos.legal_guardian.student.StudentUpdateRequestDTO;
import com.fandza.ccs.Fandza.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/guardian")
public class StudentController {


    private final StudentService service;

    public StudentController(StudentService studentService) {
        this.service = studentService;
    }


    @GetMapping("/{guardianID}/student")
    public ResponseEntity<List<StudentResponseDTO>> findByGuardian(
            @PathVariable UUID guardianID
    ){
        return ResponseEntity.ok(service.findAllStudents());

    }


    @GetMapping("/{guardianID}/student/{studentID}")
    public ResponseEntity<StudentResponseDTO> findById(
            @PathVariable UUID guardianID,
            @PathVariable UUID studentID
    ){
        return ResponseEntity.ok(service.findStudentById(studentID));
    }

    @PostMapping("/{guardianID}/student")
    public ResponseEntity<StudentResponseDTO> newStudent(
            @PathVariable UUID guardianID,
            @Valid @RequestBody StudentRequestDTO request
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.newStudent(guardianID, request));
    }

    @PutMapping("/{guardianID}/student/{studentID}")
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @PathVariable UUID guardianID,
            @PathVariable UUID studentID,
            @Valid @RequestBody StudentUpdateRequestDTO request
            ){
        return ResponseEntity.ok(
                service.updateStudent(studentID, request)
        );
    }

    @DeleteMapping("/{guardianID}/student/{studentID}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable UUID guardianID,
            @PathVariable UUID studentID
    ){
        service.deleteStudent(studentID);
        return ResponseEntity.noContent().build();
    }

}
