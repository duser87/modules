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