package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.enums.DriverStatus;
import com.fandza.ccs.Fandza.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "driver")
@PrimaryKeyJoinColumn(name = "id_driver")
public class Driver extends AppUser {


    public Driver() {}


    public Driver(
            String name,
            String email,
            String phoneNumber,
            String password,
            String drivingLicenseNumber,
            LocalDate licenseIssueDate
    ){
        super(name,email,phoneNumber,password, UserType.DRIVER);
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.licenseIssueDate = licenseIssueDate;
        this.status = DriverStatus.PENDING;

    }


    @Column(name = "driving_license_number",
            nullable = false,
            unique = true
    )
    private String drivingLicenseNumber;

    @Column(
            name = "license_issue_date",
            nullable = false
    )
    @CreationTimestamp
    private LocalDate licenseIssueDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DriverStatus status;

    @Column(name = "status_uploaded_at")
    @CreationTimestamp
    private LocalDateTime statusUploadedAt;

    @Column(
            name = "status_reason"
    )
    private String statusReason;

    @Column(name = "average_rating")
    private Double averageRating;

    @Column(name = "total_assessments")
    private Integer totalAssessments = 0;

    @OneToOne(mappedBy = "driver", fetch = FetchType.LAZY)
    private Vehicle vehicle;

    @OneToMany(mappedBy = "driver")
    private List<Assessment> assessments = new ArrayList<>();

    @OneToMany(
            mappedBy = "driver",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Document> documents = new ArrayList<>();





}
