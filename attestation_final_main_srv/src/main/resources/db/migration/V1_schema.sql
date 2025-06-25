-- Создание таблицы Users (Пользователи) со следующими полями:

CREATE TABLE IF NOT EXISTS users
(
    "id" bigint primary key not null,
    "name" varchar,
    "username" varchar,
    "email" varchar,
    "password" varchar
);

-- Создание таблицы Roles (Роли) со следующими полями:

CREATE TABLE IF NOT EXISTS roles
(
    "id" bigint primary key not null,
    "name" varchar
);

-- Создание таблицы Users_Roles (Пользователи-Роли) со следующими полями:

CREATE TABLE IF NOT EXISTS users_roles
(
    "id" bigint primary key not null,
    "user_id" bigint,
    "role_id" bigint
);