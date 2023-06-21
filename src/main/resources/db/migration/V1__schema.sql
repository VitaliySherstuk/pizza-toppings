CREATE TABLE users
(
    id serial NOT NULL PRIMARY KEY,
    email VARCHAR(100)
);

CREATE TABLE toppings
(
    id serial NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    user_id SERIAL NOT NULL
);

ALTER TABLE toppings
    ADD CONSTRAINT FK_users_TO_toppings
        FOREIGN KEY (user_id)
            REFERENCES users (id);