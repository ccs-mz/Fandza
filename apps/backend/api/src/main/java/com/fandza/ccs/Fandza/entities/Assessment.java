package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "assessment")
public class Assessment {

    protected Assessment() {}


    public Assessment(
            Integer classification,
            String comment,
            LocalDateTime date,
            LegalGuardian legalGuardian,
            Driver driver

    ) {
        this.classification = classification;
        this.comment = comment;
        this.legalGuardian = legalGuardian;
        this.driver = driver;
        this.date = LocalDateTime.now();

    }


    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "id_assessment")
    private UUID idAssessment;

    private Integer classification;

    private String comment;

    private LocalDateTime date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_legal_guardian", nullable = false)
    private LegalGuardian legalGuardian;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_driver")
    private Driver driver;

}
