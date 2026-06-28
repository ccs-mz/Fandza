package com.fandza.ccs.Fandza.services;


import com.fandza.ccs.Fandza.dtos.vehicle.VehicleRequestDTO;
import com.fandza.ccs.Fandza.dtos.vehicle.VehicleResponseDTO;
import com.fandza.ccs.Fandza.dtos.vehicle.VehicleUpdateRequestDTO;
import com.fandza.ccs.Fandza.entities.Vehicle;
import com.fandza.ccs.Fandza.exception.ResourceNotFoundException;
import com.fandza.ccs.Fandza.mappers.VehicleMapper;
import com.fandza.ccs.Fandza.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }


    public List<VehicleResponseDTO> findAllVehicles(){
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(vehicleMapper::toResponse)
                .toList();
    }

    public VehicleResponseDTO findVehicleById(UUID id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("VEHICLE_NOT_FOUND","Veiculo não Emncontrado"));

        return vehicleMapper.toResponse(vehicle);
    }


    public VehicleResponseDTO createVehicle (VehicleRequestDTO request){

        var newVehicle = vehicleMapper.toEntity(request);
        var savedVehicle = vehicleRepository.save(newVehicle);
        return vehicleMapper.toResponse(savedVehicle);
    }


    public VehicleResponseDTO updateVehicle(UUID id, VehicleUpdateRequestDTO request){
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VEHICLE_NOT_FOUND","Veiculo não Emncontrado"));

        vehicle.setModel(request.model());
        vehicle.setColor(request.color());
        vehicle.setBrand(request.brand());
        vehicle.setCapacity(request.capacity());

        var saved = vehicleRepository.save(vehicle);

        return vehicleMapper.toResponse(saved);
    }

     public void deleteVehicle(UUID id){
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VEHICLE_NOT_FOUND","Veiculo não Emncontrado"));
        vehicleRepository.delete(vehicle);
     }




}
