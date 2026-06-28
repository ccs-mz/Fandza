package com.fandza.ccs.Fandza.services;

import com.fandza.ccs.Fandza.dtos.driver.DriverRequestDTO;
import com.fandza.ccs.Fandza.dtos.driver.DriverResponseDTO;
import com.fandza.ccs.Fandza.dtos.driver.DriverUpdateRequestDTO;
import com.fandza.ccs.Fandza.entities.Driver;
import com.fandza.ccs.Fandza.exception.ResourceNotFoundException;
import com.fandza.ccs.Fandza.mappers.DriverMapper;
import com.fandza.ccs.Fandza.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;


    public DriverService(
            DriverRepository driverRepository,
            DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }


    public List<DriverResponseDTO> findAllDrivers() {
        List<Driver> drivers = driverRepository.findAll();

        return drivers.stream()
                .map(driverMapper::toResponse)
                .toList();
    }

    public DriverResponseDTO findDriverById(UUID id){


        Driver driver = driverRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("DRIVER_NOT_FOUND","Motorista Não Encontrado"));
        return driverMapper.toResponse(driver);
    }


    public DriverResponseDTO createDriver(
            DriverRequestDTO request
    ){
        var newDriver = driverMapper.toEntity(request);
        var savedDriver = driverRepository.save(newDriver);
        return driverMapper.toResponse(savedDriver);
    }

    public DriverResponseDTO updateDriver(
            UUID id,
            DriverUpdateRequestDTO request
    ){
        var driver = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DRIVER_NOT_FOUND","Motorista não Encontrado"));

        driver.setName(request.name());
        driver.setPhoneNumber(request.phoneNumber());

        Driver saved = driverRepository.save(driver);
        return driverMapper.toResponse(saved);

    }


    public void deleteDriver(UUID id){
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DRIVER_NOT_FOUND","Motorista não Encontrado"));
        driverRepository.delete(driver);
    }



}
