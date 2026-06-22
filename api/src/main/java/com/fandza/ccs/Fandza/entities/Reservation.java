package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import com.fandza.ccs.Fandza.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "reservation")
@Data
public class Reservation {


    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID idReservation;

    @Column(name = "date_reservation",
    nullable = false)
    @CreationTimestamp
    private LocalDateTime dateReservation;

    @Column(nullable = false)
    private ReservationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_legal_guardian")
    private LegalGuardian legalGuardian;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_route")
    private Route route;

}
