CREATE TABLE holder
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    diameter    INTEGER NOT NULL,
    length      INTEGER NOT NULL
);

CREATE TABLE holder_size
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(100) NOT NULL
);

