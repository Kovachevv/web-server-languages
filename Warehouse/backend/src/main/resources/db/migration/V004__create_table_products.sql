CREATE TABLE IF NOT EXISTS products (
    id BIGSERIAL,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(2000),
    buy_price NUMERIC(6,3) NOT NULL,
    sell_price NUMERIC(6,3) NOT NULL,
    quantity INTEGER NOT NULL,
    code INTEGER NOT NULL,
    CONSTRAINT products_pk PRIMARY KEY (id)
);

INSERT INTO products (name, description, buy_price, sell_price, quantity, code) VALUES
('Apple', 'Fresh red apples', 0.50, 0.75, 100, 1001),
('Notebook', '200 pages notebook', 1.20, 1.80, 150, 1002),
('Hammer', 'Steel hammer for construction', 3.00, 4.50, 50, 1003),
('Laptop', '15-inch laptop with 8GB RAM', 300.00, 450.00, 30, 1004),
('Desk Lamp', 'LED desk lamp', 15.75, 25.00, 60, 1005),
('Backpack', 'Durable outdoor backpack', 20.00, 35.00, 75, 1006),
('Water Bottle', 'Insulated water bottle', 5.00, 10.00, 100, 1007),
('Sneakers', 'Comfortable running sneakers', 25.00, 50.00, 90, 1008),
('Wristwatch', 'Water-resistant wristwatch', 50.00, 75.00, 40, 1009),
('Sunglasses', 'UV protection sunglasses', 8.50, 15.00, 80, 1010),
('Headphones', 'Wireless Bluetooth headphones', 30.00, 45.00, 70, 1011),
('Keyboard', 'Mechanical keyboard', 35.00, 60.00, 55, 1012),
('Mouse', 'Wireless ergonomic mouse', 10.00, 20.00, 85, 1013),
('Smartphone', 'Latest model smartphone', 250.00, 400.00, 25, 1014),
('Book', 'Fiction novel', 4.00, 8.00, 120, 1015),
('Camera', 'Digital SLR camera', 200.00, 350.00, 15, 1016),
('Chair', 'Ergonomic office chair', 45.00, 70.00, 40, 1017),
('Tablet', '10-inch tablet', 100.00, 150.00, 35, 1018),
('Speaker', 'Portable Bluetooth speaker', 20.00, 30.00, 65, 1019),
('Flash Drive', '32GB USB flash drive', 5.00, 10.00, 110, 1020);