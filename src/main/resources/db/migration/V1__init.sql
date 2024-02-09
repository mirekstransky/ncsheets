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
    diameter    DOUBLE NOT NULL,
    length      DOUBLE NOT NULL
);

CREATE TABLE tool
(
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(100) NOT NULL UNIQUE,
    diameter        DOUBLE NOT NULL,
    length          DOUBLE NOT NULL,
    tooltype_id     INTEGER NOT NULL,
    FOREIGN KEY (tooltype_id) REFERENCES tooltype (id)
);

CREATE TABLE holder
(
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(100) NOT NULL UNIQUE,
    diameter        DOUBLE NOT NULL,
    holdersize_id   INTEGER NOT NULL,
    length          DOUBLE NOT NULL,
    FOREIGN KEY (holdersize_id) REFERENCES holdersize (id)
);

CREATE TABLE program
(
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(100) NOT NULL UNIQUE,
    technologist    VARCHAR(100) NOT NULL,
    itemname        VARCHAR(100) NOT NULL
);

CREATE TABLE assemble
(
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(100) NOT NULL UNIQUE,
    program_id      INTEGER NOT NULL,
    adapter_id      INTEGER NOT NULL,
    holder_id       INTEGER NOT NULL,
    tool_id         INTEGER NOT NULL,
    tool_position   INTEGER NOT NULL,
    tool_length     DOUBLE NOT NULL,
    compensation_x  DOUBLE NOT NULL,
    compensation_z  DOUBLE NOT NULL,
    FOREIGN KEY (program_id) REFERENCES program (id),
    FOREIGN KEY (adapter_id) REFERENCES adapter (id),
    FOREIGN KEY (holder_id) REFERENCES holder (id),
    FOREIGN KEY (tool_id) REFERENCES tool (id)
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