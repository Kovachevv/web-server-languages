CREATE TABLE IF NOT EXISTS products_categories(
    product_id int8 NOT NULL,
    category_id int NOT NULL,
    CONSTRAINT products_categories_fk_product FOREIGN KEY (product_id) REFERENCES products(id),
    CONSTRAINT products_categories_fk_category FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO products_categories (product_id, category_id) VALUES
(1, 1),  -- Apple to GROCERY
(2, 2),  -- Notebook to STATIONARY
(3, 3),  -- Hammer to BUILDING_MATERIAL
(4, 2),  -- Laptop to STATIONARY (assuming)
(5, 3),  -- Desk Lamp to BUILDING_MATERIAL (assuming)
(6, 2),  -- Backpack to STATIONARY
(7, 1),  -- Water Bottle to GROCERY
(8, 2),  -- Sneakers to STATIONARY (assuming)
(9, 2),  -- Wristwatch to STATIONARY (assuming)
(10, 2), -- Sunglasses to STATIONARY (assuming)
(11, 2), -- Headphones to STATIONARY
(12, 2), -- Keyboard to STATIONARY
(13, 2), -- Mouse to STATIONARY
(14, 2), -- Smartphone to STATIONARY (assuming)
(15, 2), -- Book to STATIONARY
(16, 3), -- Camera to BUILDING_MATERIAL (assuming)
(17, 2), -- Chair to STATIONARY (assuming)
(18, 2), -- Tablet to STATIONARY (assuming)
(19, 2), -- Speaker to STATIONARY (assuming)
(20, 2); -- Flash Drive to STATIONARY (assuming)
