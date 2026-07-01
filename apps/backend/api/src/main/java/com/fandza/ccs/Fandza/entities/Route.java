package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "route")
@Data
public class Route {

    protected Route(){}


    public Route(
            String description,
            Integer availableVacancies

    ){
        this.description = description;
        this.availableVacancies = availableVacancies;
    }

    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "id_route")
    private UUID idRoute;

    @Column(nullable = false, length = 550)
    private String description;

    @Column(nullable = false, name = "available_vacancies")
    private Integer availableVacancies;

    @Version
    private Integer version;


    @OneToMany(mappedBy = "route")
    private List<VehicleRoute>  vehicleRoutes = new ArrayList<>();

    @OneToMany(mappedBy = "route")
    private List<Reservation> reservations = new ArrayList<>();



}
