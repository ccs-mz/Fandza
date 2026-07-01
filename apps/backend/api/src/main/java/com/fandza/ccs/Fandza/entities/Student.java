package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@Data
public class Student{

    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "id_student")
    private String idStudent;

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
