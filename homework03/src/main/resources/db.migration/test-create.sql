

CREATE TABLE IF NOT EXISTS client
(
    "id" bigint primary key not null,
    "fio" varchar,
    "tel" varchar,
    "address" varchar
);

CREATE  TABLE IF NOT EXISTS doctor
(
    "id" bigint primary key not null,
    "fio_doctor" varchar,
    "position" varchar,
    "tel_doctor" varchar
);

CREATE TABLE IF NOT EXISTS appointment
(
    "id" bigint primary key not null,
    "id_doc" bigint, FOREIGN KEY (id_doc) REFERENCES doctor(id) ON DELETE CASCADE ,
    "id_client" bigint, FOREIGN KEY (id_client) REFERENCES client(id) ON DELETE CASCADE,
    "time" varchar,
    "description" text
    );

