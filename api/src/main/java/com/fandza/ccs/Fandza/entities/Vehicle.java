package com.fandza.ccs.Fandza.entities;

import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "id_vehicle",  nullable = false)
    private String idVehicle;

    @Column(
            name = "vehicle_registration_number",
            nullable = false,
            unique = true
    )
    private String vehicleRegistrationNumber;


    @Column(
            name = "manufacture_year"
    )
    private Integer manufactureYear;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer capacity;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_driver",
            nullable = false,
            unique = true
    )
    private Driver driver;

    @OneToMany(mappedBy = "vehicle")
    private List<VehicleRoute> routes = new ArrayList<>();







}
