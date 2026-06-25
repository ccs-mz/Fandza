CREATE TABLE reservation(
    id_reservation UUID PRIMARY KEY,
    date_reservation TIMESTAMP NOT NULL,
    status VARCHAR(20) DEFAULT 'PENDING' NOT NULL
        CHECK ( status IN ('PENDING' , 'CONFIRMED', 'CANCELLED', 'REJECTED')),
    id_legal_guardian UUID NOT NULL REFERENCES legal_guardian(id_legal_guardian),
    id_route UUID NOT NULL REFERENCES route(id_route)

);