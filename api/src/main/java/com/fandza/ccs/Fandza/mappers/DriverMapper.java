package com.fandza.ccs.Fandza.mappers;


import com.fandza.ccs.Fandza.dtos.driver.DriverDetailsRequestDTO;
import com.fandza.ccs.Fandza.dtos.driver.DriverDetailsResponseDTO;
import com.fandza.ccs.Fandza.dtos.driver.DriverRequestDTO;
import com.fandza.ccs.Fandza.dtos.driver.DriverResponseDTO;
import com.fandza.ccs.Fandza.dtos.user.AppUserRequestDTO;
import com.fandza.ccs.Fandza.entities.AppUser;
import com.fandza.ccs.Fandza.entities.Driver;
import com.fandza.ccs.Fandza.repositories.AppUserRepository;
import com.fandza.ccs.Fandza.repositories.DriverRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DriverMapper {

    private final DriverRepository repository;
    private final PasswordEncoder passwordEncoder;

    public DriverMapper(DriverRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Driver toEntity(DriverRequestDTO req){
        String encodedPassword = passwordEncoder.encode(req.password());


        String drivingLicenseNumber = null;
        LocalDate drivingLicenseDate = null;

        if (req.driverDetailsRequestDTO() != null){

            drivingLicenseNumber = req.driverDetailsRequestDTO().drivingLicenseNumber();

            drivingLicenseDate = req.driverDetailsRequestDTO().licenseIssueDate();

        }

        Driver driver = new Driver();
        driver.setName(req.name());
        driver.setEmail(req.email());
        driver.setPhoneNumber(req.phoneNumber());
        driver.setPassword(encodedPassword);
        driver.setUserType(req.userType());
        driver.setDrivingLicenseNumber(drivingLicenseNumber);
        driver.setLicenseIssueDate(drivingLicenseDate);

        return driver;

    }

    public DriverResponseDTO toResponse(Driver driver){

        DriverDetailsResponseDTO detailsResponse = new DriverDetailsResponseDTO(
                driver.getDrivingLicenseNumber(),
                driver.getLicenseIssueDate(),
                driver.getStatus(),
                driver.getStatusUploadedAt(),
                driver.getStatusReason(),
                driver.getAverageRating(),
                driver.getTotalAssessments()
        );

        return  new  DriverResponseDTO(
                driver.getIdUser(),
                driver.getName(),
                driver.getEmail(),
                driver.getPhoneNumber(),
                driver.getUserType(),
                detailsResponse

        );
    }


}
