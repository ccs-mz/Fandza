package com.fandza.ccs.Fandza.mappers;


import com.fandza.ccs.Fandza.dtos.vehicle.VehicleRequestDTO;
import com.fandza.ccs.Fandza.dtos.vehicle.VehicleResponseDTO;
import com.fandza.ccs.Fandza.entities.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class VehicleMapper {

    public  Vehicle toEntity(VehicleRequestDTO req){
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleLicensePlate(req.vehicleLicensePlate());
        vehicle.setBrand(req.brand());
        vehicle.setModel(req.model());
        vehicle.setModel(req.model());
        vehicle.setColor(req.color());
        vehicle.setCapacity(req.capacity());

        return vehicle;
    }

    public VehicleResponseDTO toResponse(Vehicle vehicle){
        return new VehicleResponseDTO(
            vehicle.getIdVehicle(),
            vehicle.getVehicleLicensePlate(),
            vehicle.getBrand(),
            vehicle.getModel(),
            vehicle.getColor(),
            vehicle.getCapacity()
        );
    }


}
