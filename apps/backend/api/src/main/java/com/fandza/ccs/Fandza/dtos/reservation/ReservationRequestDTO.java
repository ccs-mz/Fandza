package com.fandza.ccs.Fandza.dtos.reservation;

import com.fandza.ccs.Fandza.enums.ReservationStatus;

import java.time.LocalDateTime;

public record ReservationRequestDTO(

        LocalDateTime dateReservation,
        ReservationStatus status



) {
}
