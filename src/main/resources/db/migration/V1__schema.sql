CREATE TABLE users
(
    id serial NOT NULL PRIMARY KEY,
    email VARCHAR(100)
);

CREATE TABLE toppings
(
    id serial NOT NULL PRIMARY KEY,
    name VARCHAR(255) unique
);

CREATE TABLE user_topping
(
  user_id BIGINT,
  topping_id BIGINT,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (topping_id) REFERENCES toppings(id)
);
