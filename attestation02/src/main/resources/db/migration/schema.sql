
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

COMMENT ON table patients IS 'The table of data about patients';
COMMENT ON COLUMN patients.id IS 'ID patient';
COMMENT ON COLUMN patients.fio IS 'Last name, first name, patronymic patient';
COMMENT ON COLUMN patients.address IS 'Address patient';
COMMENT ON COLUMN patients.tel IS 'Number telephone patient ';

-----------------------------------------------------------------------------------

-- Создание таблицы Positions (Должности) со следующими полями:
--  1. id - идентификатор элементане, не нулевое значение
--  2. position - должность врача

CREATE TABLE IF NOT EXISTS positions
(
    "id" bigint primary key not null,
    "position" varchar
);

COMMENT ON table positions IS 'Table of doctors positions';
COMMENT ON COLUMN positions.id IS 'ID position';
COMMENT ON COLUMN positions.position IS 'Position name';

------------------------------------------------------------------------------------

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

COMMENT ON table doctors IS 'The table of data about doctors';
COMMENT ON COLUMN doctors.id IS 'ID doctor';
COMMENT ON COLUMN doctors.id_pos IS 'Position of doctor';
COMMENT ON COLUMN doctors.fio_d IS 'Last name, first name, patronymic doctor';
COMMENT ON COLUMN doctors.tel_d IS 'Number telephone doctor ';

-----------------------------------------------------------------------------------

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

COMMENT ON table appointments IS 'The table of data about doctors';
COMMENT ON COLUMN appointments.id IS 'ID appointment';
COMMENT ON COLUMN appointments.id_d IS 'ID doctor, foreign key from table doctors';
COMMENT ON COLUMN appointments.id_p IS 'ID patient, foreign key from table patients';
COMMENT ON COLUMN appointments.time IS 'Time appointments ';
COMMENT ON COLUMN appointments.description IS 'Description appointment';
