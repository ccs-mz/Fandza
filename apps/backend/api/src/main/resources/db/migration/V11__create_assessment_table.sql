CREATE TABLE assessment(
    id_assessment UUID PRIMARY KEY,
    classification INTEGER NOT NULL CHECK ( classification BETWEEN 1 AND 5),
    comment VARCHAR(1000),
    date TIMESTAMP NOT NULL DEFAULT now(),
    id_legal_guardian UUID NOT NULL  REFERENCES legal_guardian(id_legal_guardian),
    id_driver UUID NOT NULL REFERENCES driver(id_driver)
);