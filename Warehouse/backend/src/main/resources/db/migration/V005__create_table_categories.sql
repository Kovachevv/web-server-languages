CREATE TABLE IF NOT EXISTS categories (
    id BIGSERIAL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT categories_pk PRIMARY KEY (id)
);

INSERT INTO categories("name")
VALUES ('GROCERIES'),
       ('OFFICE_SUPPLIES'),
       ('BUILDING_MATERIAL');

