CREATE TABLE IF NOT EXISTS users
(
    id       bigint auto_increment PRIMARY KEY,
    name     VARCHAR NOT NULL,
    username VARCHAR NOT NULL,
    password VARCHAR NOT NULL
);

INSERT INTO users(name, username, password)
VALUES ('Sameer', 'sammy', 'password1');

INSERT INTO users(name, username, password)
VALUES ('Max', 'Mustermann', 'password2');
