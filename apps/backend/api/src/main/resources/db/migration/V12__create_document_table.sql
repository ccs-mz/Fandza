CREATE TABLE document(
    id_document UUID PRIMARY KEY,
    document_type VARCHAR(30) NOT NULL
        CHECK ( document_type IN ('DRIVING_LICENSE','BI','PROFILE_PHOTO','VEHICLE_REGISTRATION')),
    file_url VARCHAR(550) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING'
        CHECK ( status IN ('PENDING', 'APPROVED', 'REJECTED')),
    uploaded_at TIMESTAMP NOT NULL  DEFAULT now(),
    reviewed_at TIMESTAMP,
    rejection_reason VARCHAR(255),
    id_driver UUID NOT NULL REFERENCES driver(id_driver),
    id_vehicle UUID NOT NULL REFERENCES vehicle(id_vehicle)

);