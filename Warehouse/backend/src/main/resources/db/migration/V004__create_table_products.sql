CREATE TABLE IF NOT EXISTS products (
    id BIGSERIAL,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(2000),
    buy_price NUMERIC(6,3) NOT NULL,
    sell_price NUMERIC(6,3) NOT NULL,
    quantity INTEGER NOT NULL,
    code INTEGER NOT NULL,
    CONSTRAINT products_pk PRIMARY KEY (id)
)