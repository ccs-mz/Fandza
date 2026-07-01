CREATE TABLE route(
    id_route UUID PRIMARY KEY,
    description VARCHAR(550) NOT NULL,
    available_vacancies INTEGER NOT NULL CHECK ( available_vacancies >= 0 ),
    version BIGINT NOT NULL DEFAULT 0

);