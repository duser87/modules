CREATE TABLE IF NOT EXISTS users
(
    "id" bigint primary key not null,
    "id_usr" bigint,
    "username" varchar,
    "password" varchar,
    "email" varchar,
    "permit" boolean,
    "time" TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp
);