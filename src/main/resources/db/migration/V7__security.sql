CREATE TABLE members (
    user_id VARCHAR(50) UNIQUE NOT NULL,
    password CHAR(68) NOT NULL,
    active TINYINT NOT NULL
);

INSERT INTO members
VALUES
    ('OPERATOR','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
    ('MANAGER','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
    ('ADMIN','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);


CREATE TABLE roles (
    user_id VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES members (user_id)
);

INSERT INTO roles
VALUES
    ('OPERATOR','ROLE_OPERATOR'),

    ('MANAGER','ROLE_OPERATOR'),
    ('MANAGER','ROLE_MANAGER'),

    ('ADMIN','ROLE_OPERATOR'),
    ('ADMIN','ROLE_MANAGER'),
    ('ADMIN','ROLE_ADMIN');