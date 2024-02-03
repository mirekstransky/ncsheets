CREATE TABLE holdersize
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE
);


CREATE TABLE tooltype
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE adapter
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE,
    diameter    VARCHAR(100) NOT NULL,
    length      VARCHAR(100) NOT NULL
);

CREATE TABLE tool
(
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(100) NOT NULL UNIQUE,
    tooltype_id     INTEGER NOT NULL,
    FOREIGN KEY (tooltype_id) REFERENCES tooltype (id)
);

CREATE TABLE holder
(
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(100) NOT NULL UNIQUE,
    diameter        INTEGER NOT NULL,
    holdersize_id   INTEGER NOT NULL,
    length          INTEGER NOT NULL,
    FOREIGN KEY (holdersize_id) REFERENCES holdersize (id)
);

-- CREATE TABLE members
-- (
--     id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     password char(68) NOT NULL,
--     active tinyint NOT NULL
-- );
--
-- CREATE TABLE roles (
--     id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     role varchar(50) NOT NULL,
--     FOREIGN KEY (id) REFERENCES members (id)
-- );