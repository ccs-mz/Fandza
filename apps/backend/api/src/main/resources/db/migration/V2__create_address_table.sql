CREATE TABLE address(
    id_address UUID PRIMARY KEY,
    neighborhood VARCHAR(255) NOT NULL,
    block VARCHAR(255) NOT NULL,
    house_number VARCHAR(20) NOT NULL
);