
CREATE TABLE IF NOT EXISTS students
(
    "id" bigint primary key not null,
    "fio" varchar,
    "email" varchar
);

COMMENT ON table students IS 'The table students';
COMMENT ON COLUMN students.id IS 'ID student';
COMMENT ON COLUMN students.fio IS 'This fio student';
COMMENT ON COLUMN students.email IS 'This email student';

CREATE TABLE IF NOT EXISTS courses
(
    "id" bigint primary key not null,
    "name" varchar
);

COMMENT ON table courses IS 'The table course';
COMMENT ON COLUMN courses.id IS 'ID course';
COMMENT ON COLUMN courses.name IS 'This name course';

CREATE TABLE IF NOT EXISTS list_courses
(
    "id" bigint primary key not null,
    "id_student" bigint, FOREIGN KEY (id_student) REFERENCES students(id),
    "id_course" bigint, FOREIGN KEY (id_course) REFERENCES courses(id)
);

COMMENT ON table list_courses IS 'The table list_courses';
COMMENT ON COLUMN list_courses.id_student IS 'ID student';
COMMENT ON COLUMN list_courses.id_course IS 'ID courses';