CREATE TABLE vehicle(
    id_vehicle UUID PRIMARY KEY,
    vehicle_license_plate VARCHAR(60) NOT NULL UNIQUE,
    brand VARCHAR(100) NOT NULL ,
    model VARCHAR(100) NOT NULL,
    color VARCHAR(50) NOT NULL ,
    capacity INTEGER NOT NULL,
    id_driver UUID NOT NULL UNIQUE REFERENCES driver(id_driver)
);