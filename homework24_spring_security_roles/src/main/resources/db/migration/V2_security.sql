CREATE TABLE IF NOT EXISTS users
(
    "id" bigint primary key not null,
    "username" varchar,
    "password" varchar,
    "role" varchar
);

COMMENT ON table users IS 'The table users';
COMMENT ON COLUMN users.username IS 'Login';
COMMENT ON COLUMN users.password IS 'Password';
