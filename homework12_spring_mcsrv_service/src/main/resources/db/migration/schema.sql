
CREATE TABLE IF NOT EXISTS courses
(
    "id" bigint primary key not null,
    "name" varchar
);

COMMENT ON table courses IS 'The table course';
COMMENT ON COLUMN courses.id IS 'ID course';
COMMENT ON COLUMN courses.name IS 'This name course';
