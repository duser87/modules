
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

CREATE TABLE IF NOT EXISTS student_courses
(
    "id" bigint primary key not null,
    "id_student" bigint, FOREIGN KEY (id_student) REFERENCES students(id),
    "id_course" bigint,
    "start_date" TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
    "activity" boolean
);

COMMENT ON table student_courses IS 'The table list_courses';
COMMENT ON COLUMN student_courses.id_student IS 'ID student';
COMMENT ON COLUMN student_courses.id_course IS 'ID courses';
COMMENT ON COLUMN student_courses.start_date IS 'The beginning of the course';
COMMENT ON COLUMN student_courses.activity IS 'Is the course active';