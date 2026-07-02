package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "student")
@Data
public class Student{


    public Student(
            String name,
            LocalDate dateOfBirth,
            LegalGuardian legalGuardian

    ){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.legalGuardian = legalGuardian;
    }

    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "id_student")
    private UUID idStudent;

    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private String grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_legal_guardian", nullable = false)
    private LegalGuardian legalGuardian;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_school")
    private School school;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address")
    private Address address;

}
