CREATE TABLE IF NOT EXISTS users
(
    id       bigint auto_increment PRIMARY KEY,
    name     VARCHAR NOT NULL,
    username VARCHAR NOT NULL,
    password VARCHAR NOT NULL
);

INSERT INTO users(name, username, password)
VALUES ('Sameer', 'sammy', '$2a$12$TA7hgHFZXE7LQcpD.AR3TeN30N5pC8GzFT2soaLeYrHNh9Hk.2.Rm');

INSERT INTO users(name, username, password)
VALUES ('Max', 'Mustermann', 'password2');
