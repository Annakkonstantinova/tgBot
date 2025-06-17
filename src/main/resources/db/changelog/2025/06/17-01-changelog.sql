-- changeset kkons:1750188336259-3
CREATE SEQUENCE IF NOT EXISTS role_id_seq START WITH 1 INCREMENT BY 1;

-- changeset kkons:1750188336259-4
CREATE SEQUENCE IF NOT EXISTS user_id_seq START WITH 1 INCREMENT BY 1;

-- changeset kkons:1750188336259-7
CREATE TABLE role_authorities
(
    role_id   BIGINT NOT NULL,
    authority VARCHAR(255)
);

-- changeset kkons:1750188336259-8
CREATE TABLE roles
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

-- changeset kkons:1750188336259-9
CREATE TABLE users
(
    id       BIGINT       NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id  BIGINT       NOT NULL,
    enabled  BOOLEAN      NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

-- changeset kkons:1750188336259-10
ALTER TABLE roles
    ADD CONSTRAINT uc_roles_name UNIQUE (name);

-- changeset kkons:1750188336259-11
ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

-- changeset kkons:1750188336259-13
ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);

-- changeset kkons:1750188336259-14
ALTER TABLE role_authorities
    ADD CONSTRAINT fk_role_authorities_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

