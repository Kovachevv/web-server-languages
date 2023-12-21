CREATE TABLE IF NOT EXISTS users(
    id BIGSERIAL,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255),
    CONSTRAINT users_pk PRIMARY KEY (id)
)