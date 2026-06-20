package com.fandza.ccs.Fandza.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student extends   AppUser {

    private LocalDate dateOfBirth;

    private String grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_legal_guardian", nullable = false)
    private LegalGuardian legalGuardian;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_school")
    private School school;

}
