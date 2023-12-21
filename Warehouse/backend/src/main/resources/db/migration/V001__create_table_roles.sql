CREATE TABLE IF NOT EXISTS roles(
    id BIGSERIAL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT roles_pk PRIMARY KEY (id)
);

INSERT INTO roles("name")
VALUES
    ('ADMIN'),
    ('USER');