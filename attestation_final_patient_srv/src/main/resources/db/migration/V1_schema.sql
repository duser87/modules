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