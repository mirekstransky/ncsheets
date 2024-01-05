CREATE TABLE holdersize
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(100) NOT NULL
);

CREATE TABLE tooltype
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(100) NOT NULL
);

CREATE TABLE adapter
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    diameter    VARCHAR(100) NOT NULL,
    length      VARCHAR(100) NOT NULL
);

CREATE TABLE tool
(
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    tooltype_id     INTEGER NOT NULL,
    FOREIGN KEY (tooltype_id) REFERENCES tooltype (id)
);

CREATE TABLE holder
(
    id              INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    diameter        INTEGER NOT NULL,
    holdersize_id   INTEGER NOT NULL,
    length          INTEGER NOT NULL,
    FOREIGN KEY (holdersize_id) REFERENCES holdersize (id)
);
