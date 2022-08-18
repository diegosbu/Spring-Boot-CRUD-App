CREATE TABLE IF NOT EXISTS users (
    user_id serial PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS players (
    user_id serial REFERENCES users(user_id),
    player_id int NOT NULL,
    PRIMARY KEY (user_id, player_id)
);