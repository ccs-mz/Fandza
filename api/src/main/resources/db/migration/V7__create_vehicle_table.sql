CREATE TABLE vehicle(
    id_vehicle UUID PRIMARY KEY,
    vehicle_registration_number VARCHAR(60) NOT NULL UNIQUE,
    manufacture_year INTEGER NOT NULL,
    model VARCHAR(100) NOT NULL,
    capacity INTEGER NOT NULL,
    id_driver UUID NOT NULL UNIQUE REFERENCES driver(id_driver)
);