-- liquibase formatted sql

-- changeset kkons:1748178587957-1
CREATE SEQUENCE IF NOT EXISTS joke_call_id_seq START WITH 1 INCREMENT BY 1;

-- changeset kkons:1748178587957-2
CREATE SEQUENCE IF NOT EXISTS joke_id_seq START WITH 1 INCREMENT BY 1;

-- changeset kkons:1748178587957-3
CREATE TABLE joke_calls
(
    id        BIGINT NOT NULL,
    call_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    user_id   BIGINT NOT NULL,
    joke_id   BIGINT NOT NULL,
    CONSTRAINT pk_joke_calls PRIMARY KEY (id)
);

-- changeset kkons:1748178587957-4
CREATE TABLE jokes
(
    id      BIGINT NOT NULL,
    title   VARCHAR(255),
    content VARCHAR(255),
    CONSTRAINT pk_jokes PRIMARY KEY (id)
);

-- changeset kkons:1748178587957-5
ALTER TABLE joke_calls
    ADD CONSTRAINT FK_JOKE_CALLS_ON_JOKE FOREIGN KEY (joke_id) REFERENCES jokes (id);

