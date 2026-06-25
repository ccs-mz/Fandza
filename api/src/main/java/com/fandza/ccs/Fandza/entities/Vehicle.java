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
@Data
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "id_vehicle",  nullable = false)
    private UUID idVehicle;

    @Column(
            name = "vehicle_license_plate",
            nullable = false,
            unique = true
    )
    private String vehicleLicensePlate;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;



    @Column(nullable = false)
    private String  color;

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
