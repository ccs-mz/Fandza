package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Data
@Table(name = "vehicle_routes")
public class VehicleRoute {

    protected VehicleRoute() {}

    public VehicleRoute(
            Vehicle vehicle,
            Route route
    ){
        this.vehicle = vehicle;
        this.route = route;
    }

    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "id_vehicle_routes")
    private UUID idVehicleRoutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicle", nullable = false)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_route", nullable = false)
    private Route route;

}
