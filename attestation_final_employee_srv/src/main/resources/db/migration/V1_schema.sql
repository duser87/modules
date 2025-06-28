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