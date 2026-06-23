CREATE TABLE vehicle_route(
    id_vehicle_routes UUID PRIMARY KEY,
    id_vehicle UUID UNIQUE NOT NULL REFERENCES vehicle(id_vehicle),
    id_route UUID UNIQUE NOT NULL REFERENCES route(id_route),
    CONSTRAINT uq_vehicle_route UNIQUE (id_vehicle, id_route)

);