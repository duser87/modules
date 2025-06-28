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
COMMENT ON COLUMN appointments.description IS 'Description appointment';
COMMENT ON COLUMN appointments.del IS 'Soft delete FLAG';
