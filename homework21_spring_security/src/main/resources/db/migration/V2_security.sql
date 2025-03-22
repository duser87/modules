
CREATE TABLE IF NOT EXISTS users
(
    "id" bigint,
    "username" varchar,
    "password" varchar,
    "enabled" boolean,
    "priority" bigint
);

COMMENT ON table users IS 'The table users';
COMMENT ON COLUMN users.username IS 'Login';
COMMENT ON COLUMN users.password IS 'Password';
COMMENT ON COLUMN users.enabled IS 'Is the active profile';
COMMENT ON COLUMN users.priority IS 'Priority';

CREATE TABLE IF NOT EXISTS authorities
(

    "username" varchar,
    "authority" varchar
);