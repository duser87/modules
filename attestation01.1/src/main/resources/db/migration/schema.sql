
-- Создание таблицы Patients (Пациенты) со следующими полями:
--  1. id - идентификатор элемента, не нулевое значение
--  2. fio - ФамилияИмяОтчество пациента
--  3. tel - номер телефона
--  4. address - адрес

CREATE TABLE IF NOT EXISTS patients
(
    "id" bigint primary key not null,
    "fio" varchar,
    "tel" varchar,
    "address" varchar
);

-- Создание таблицы Positions (Должности) со следующими полями:
--  1. id - идентификатор элементане, не нулевое значение
--  2. position - должность врача

CREATE TABLE IF NOT EXISTS positions
(
    "id" bigint primary key not null,
    "position" varchar
);

-- Создание таблицы Doctors (Врачи) со следующими полями:
--  1. id - идентификатор элемента, не нулевое значение
--  2. id_pos - ссылка на номер позиции в таблице "Должность"
--  3. fio_d - ФамилияИмяОтчество врача
--  4. tel_d - номер телефона врача

CREATE  TABLE IF NOT EXISTS doctors
(
    "id" bigint primary key not null,
    "id_pos" bigint, FOREIGN KEY (id_pos) REFERENCES positions(id),
    "fio_d" varchar,
    "tel_d" varchar
);

-- Создание таблицы Appointments (Прием) со следующими полями:
--  1. id - идентификатор элемента, не нулевое значение
--  2. id_d - ссылка на номер позиции в таблице "Должность"
--  3. id_p - ФамилияИмяОтчество врача
--  4. time - номер телефона врача
--  5. description - описание приема

CREATE TABLE IF NOT EXISTS appointments
(
    "id" bigint primary key not null,
    "id_d" bigint, FOREIGN KEY (id_d) REFERENCES doctors(id) ON DELETE CASCADE , -- каскадное удаление
    "id_p" bigint, FOREIGN KEY (id_p) REFERENCES patients(id) ON DELETE CASCADE,
    "time" varchar,
    "description" text
);