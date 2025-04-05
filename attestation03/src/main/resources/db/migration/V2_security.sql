CREATE TABLE IF NOT EXISTS users
(
    "id" bigint primary key not null,
    "id_patients" bigint, FOREIGN KEY (id_patients) REFERENCES patients(id),
    "username" varchar,
    "password" varchar,
    "permit" boolean,
    "time" TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp
);