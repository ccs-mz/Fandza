CREATE TABLE app_users(
    id_user UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(20),
    password VARCHAR(255) NOT NULL,
    user_type VARCHAR(20) NOT NULL CHECK ( user_type IN ('LEGAL_GUARDIAN', 'DRIVER'))
);