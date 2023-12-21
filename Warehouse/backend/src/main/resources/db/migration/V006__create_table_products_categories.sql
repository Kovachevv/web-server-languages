CREATE TABLE IF NOT EXISTS products_categories(
    product_id int8 NOT NULL,
    category_id int NOT NULL,
    CONSTRAINT products_categories_fk_product FOREIGN KEY (product_id) REFERENCES products(id),
    CONSTRAINT products_categories_fk_category FOREIGN KEY (category_id) REFERENCES categories(id)
)