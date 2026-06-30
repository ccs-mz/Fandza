package com.fandza.ccs.Fandza.services;


import com.fandza.ccs.Fandza.dtos.document.DocumentResponseDTO;
import com.fandza.ccs.Fandza.dtos.document.DriverDocumentRequestDTO;
import com.fandza.ccs.Fandza.dtos.document.VehicleDocumentRequestDTO;
import com.fandza.ccs.Fandza.entities.Document;
import com.fandza.ccs.Fandza.entities.Driver;
import com.fandza.ccs.Fandza.entities.Vehicle;
import com.fandza.ccs.Fandza.exception.ResourceNotFoundException;
import com.fandza.ccs.Fandza.mappers.DocumentMapper;
import com.fandza.ccs.Fandza.repositories.DocumentRepository;
import com.fandza.ccs.Fandza.repositories.DriverRepository;
import com.fandza.ccs.Fandza.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;

    public DocumentService(
            DocumentRepository documentRepository,
            DocumentMapper documentMapper,
            VehicleRepository vehicleRepository,
            DriverRepository driverRepository
    ){
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }

    public DocumentResponseDTO uploadDriverDocument(UUID driverId, DriverDocumentRequestDTO request) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new ResourceNotFoundException("DRIVER_NOT_FOUND", "Motorista não Encontrado"));

        Document document = new Document(
                request.documentType(),
                request.fileUrl(),
                driver
        );

        Document saved = documentRepository.save(document);

        return documentMapper.toResponse(saved);

    }

    public DocumentResponseDTO uploadVehicleDocument(UUID vehicleId, VehicleDocumentRequestDTO request) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("VEHICLE_NOT_FOUND", "Veiculo não Encontrado"));

        Document document = new Document(
                request.documentType(),
                request.fileUrl(),
                vehicle
        );

        Document saved = documentRepository.save(document);
        return documentMapper.toResponse(saved);
    }


}
