
CREATE TABLE IF NOT EXISTS courses
(
    "id" bigint primary key not null,
    "course" varchar
);

COMMENT ON table courses IS 'Table courses';
COMMENT ON COLUMN courses.id IS 'ID course';
COMMENT ON COLUMN courses.course IS 'Name course';

CREATE TABLE IF NOT EXISTS students
(
    "id" bigint primary key not null,
    "fio" varchar,
    "email" varchar
);

COMMENT ON table students IS 'The table students';
COMMENT ON COLUMN students.id IS 'ID student';
COMMENT ON COLUMN students.fio IS 'This fio student';

CREATE TABLE IF NOT EXISTS list_courses
(
    "id" bigint primary key not null,
    "id_fio" bigint, FOREIGN KEY (id_fio) REFERENCES students(id),
    "id_course" bigint, FOREIGN KEY (id_course) REFERENCES courses(id)
);

COMMENT ON table students IS 'The table students';
COMMENT ON COLUMN students.id IS 'ID student';
COMMENT ON COLUMN students.fio IS 'This fio student';