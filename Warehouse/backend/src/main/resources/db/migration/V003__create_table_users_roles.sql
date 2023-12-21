CREATE TABLE IF NOT EXISTS users_roles(
    user_id int8 NOT NULL,
    role_id int8 NOT NULL,
    CONSTRAINT users_roles_fk_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT users_roles_fk_role FOREIGN KEY (role_id) REFERENCES roles (id)
);