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
--  2. position - должность сотрудника

CREATE TABLE IF NOT EXISTS positions
(
    "id" bigint primary key not null,
    "position" varchar
);

COMMENT ON table positions IS 'Table positions';
COMMENT ON COLUMN positions.id IS 'ID position';
COMMENT ON COLUMN positions.position IS 'Position name';

------------------------------------------------------------------------------------

-- Создание таблицы Employees (Работники) со следующими полями:
--  1. id - идентификатор элемента, не нулевое значение
--  3. fio - ФамилияИмяОтчество работника
--  4. tel - номер телефона работника
CREATE TABLE IF NOT EXISTS employees
(
    "id" bigint primary key not null,
    "fio" varchar,
    "tel" varchar
);

COMMENT ON table employees IS 'The table of employees';
COMMENT ON COLUMN employees.id IS 'ID employee';
COMMENT ON COLUMN employees.fio IS 'FIO employee';
COMMENT ON COLUMN employees.tel IS 'TEL employee';

-----------------------------------------------------------------------------------

-- Создание таблицы Post (Работники медучереждения) со следующими полями:
--  1. id - идентификатор элемента, не нулевое значение
--  2. id_pos - ссылка на номер позиции в таблице "Должность"
--  3. id_empl - ссылка на номер работника в таблице "Работник"
CREATE  TABLE IF NOT EXISTS posts
(
    "id" bigint primary key not null,
    "id_pos" bigint,-- FOREIGN KEY (id_pos) REFERENCES positions(id),
    "id_empl" bigint
);

COMMENT ON table posts IS 'The table of data about doctors';
COMMENT ON COLUMN posts.id IS 'ID employee';
COMMENT ON COLUMN posts.id_empl IS 'Position of employee';

-----------------------------------------------------------------------------------

-- Создание таблицы Appointments (Прием) со следующими полями:
--  1. id - идентификатор элемента, не нулевое значение
--  2. id_d - ссылка на номер позиции в таблице "Должность"
--  3. id_p - ФамилияИмяОтчество работника
--  4. time - время приема
--  5. description - описание приема
--  6. delete - программный флаг удаления записи

CREATE TABLE IF NOT EXISTS appointments
(
    "id" bigint primary key not null,
    "id_empl" bigint,-- FOREIGN KEY (id_empl) REFERENCES employees(id) ON DELETE CASCADE , -- каскадное удаление
    "id_pat" bigint,-- FOREIGN KEY (id_p) REFERENCES patients(id) ON DELETE CASCADE,
    "time" varchar,
    "description" text,
    "del" boolean
);

COMMENT ON table appointments IS 'The table of data about doctors';
COMMENT ON COLUMN appointments.id IS 'ID appointment';
COMMENT ON COLUMN appointments.id_empl IS 'ID doctor, foreign key from table doctors';
COMMENT ON COLUMN appointments.id_pat IS 'ID patient, foreign key from table patients';
COMMENT ON COLUMN appointments.time IS 'Time appointments ';
COMMENT ON COLUMN appointments.description IS 'Description appointment';\
COMMENT ON COLUMN appointments.del IS 'Soft delete FLAG';