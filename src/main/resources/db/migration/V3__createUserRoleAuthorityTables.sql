CREATE TABLE IF NOT EXISTS role
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    email VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(256) NOT NULL,
    role_id  BIGINT,
    FOREIGN KEY (role_id) references role (id)
);

CREATE TABLE IF NOT EXISTS authority
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS role_authorities
(
    authority_id BIGINT,
    role_id      BIGINT,
    FOREIGN KEY (authority_id) references authority (id),
    FOREIGN KEY (role_id) references role (id),
    PRIMARY KEY (authority_id, role_id)
);

