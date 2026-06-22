package com.fandza.ccs.Fandza.entities;


import com.fandza.ccs.Fandza.config.uuid.UuidV7;
import com.fandza.ccs.Fandza.enums.DocumentStatus;
import com.fandza.ccs.Fandza.enums.DocumentType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "document")
@Data
public class Document {


    protected Document(){}

    public Document(
            DocumentType documentType,
            String fileUrl,
            Driver driver
            ){
        this.documentType = documentType;
        this.fileUrl = fileUrl;
        this.driver = driver;
        this.status = DocumentStatus.PENDING;
        this.uploadedAt =  LocalDateTime.now();
    }

    public Document(
            DocumentType documentType,
            String fileUrl,
            Vehicle vehicle
    ){
        this.documentType = documentType;
        this.fileUrl = fileUrl;
        this.vehicle = vehicle;
        this.status = DocumentStatus.PENDING;
        this.uploadedAt =  LocalDateTime.now();
    }

    public void approve(){
        this.status = DocumentStatus.APPROVED;
        this.reviewedAt = LocalDateTime.now();
        this.rejectionReason = null;
    }

    public void reject(String reason){
        this.status = DocumentStatus.REJECTED;
        this.reviewedAt = LocalDateTime.now();
        this.rejectionReason = reason;

    }


    @Id
    @UuidV7
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID idDocument;

    @Enumerated(EnumType.STRING)
    @Column(
            nullable = false
    )
    private DocumentType documentType;

    @Column(name = "file_url",
            nullable = false
    )
    private String fileUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentStatus status;

    @Column(
            name = "uploaded_at",
            nullable = false,
            updatable = false
    )
    @CreationTimestamp
    private LocalDateTime uploadedAt;

    @CreationTimestamp
    @Column(
            nullable = false,
            updatable = false,
            name = "reviewed_at"
    )
    private LocalDateTime reviewedAt;


    @Column(
            name = "rejection_reason"
    )
    private String rejectionReason;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_driver")
    private Driver driver;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle;



}
