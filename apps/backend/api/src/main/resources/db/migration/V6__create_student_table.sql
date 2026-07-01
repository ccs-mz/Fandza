CREATE TABLE student(
    id_student UUID PRIMARY KEY ,
    name VARCHAR(255) NOT NULL ,
    grade VARCHAR(20),
    date_of_birth DATE NOT NULL ,
    id_legal_guardian UUID NOT NULL REFERENCES legal_guardian(id_legal_guardian),
    id_school UUID REFERENCES school(id_school),
    id_address UUID REFERENCES address(id_address)

);