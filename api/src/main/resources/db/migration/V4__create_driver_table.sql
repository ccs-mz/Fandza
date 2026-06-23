CREATE TABLE driver(
    id_driver UUID PRIMARY KEY REFERENCES app_users(id_user) ON DELETE CASCADE,
    driving_license_number VARCHAR(50) NOT NULL UNIQUE,
    license_issue_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING'
                   CHECK ( status IN ('PENDING' , 'APPROVED' , 'REJECTED' , 'SUSPENDED')),
    status_uploaded_at TIMESTAMP,
    status_reason VARCHAR(255),
    average_rating NUMERIC(3,2),
    total_assessments INTEGER NOT NULL DEFAULT  0

);