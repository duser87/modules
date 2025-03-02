
CREATE TABLE IF NOT EXISTS info
(
    "id" bigint primary key not null,
    "id_course" bigint,
    "date_start" DATE,
    "archive" boolean
);

COMMENT ON table info IS 'The table information';
COMMENT ON COLUMN info.id IS 'ID info';
COMMENT ON COLUMN info.id_course IS 'This id course';
COMMENT ON COLUMN info.date_start IS 'Date course starts';
COMMENT ON COLUMN info.archive IS 'This index to the archive';