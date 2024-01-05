CREATE TABLE holdersize
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR(100) NOT NULL
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



