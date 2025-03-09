
CREATE TABLE IF NOT EXISTS students
(
    "id" bigint primary key not null,
    "fio" varchar,
    "email" varchar,
    "age" bigint
);

COMMENT ON table students IS 'The table students';
COMMENT ON COLUMN students.id IS 'ID student';
COMMENT ON COLUMN students.fio IS 'This fio student';
COMMENT ON COLUMN students.email IS 'This email student';
COMMENT ON COLUMN students.age IS 'This age student';

CREATE TABLE IF NOT EXISTS student_courses
(
    "id" bigint primary key not null,
    "id_student" bigint, FOREIGN KEY (id_student) REFERENCES students(id),
    "id_course" bigint,
    "date_start" DATE,
    "activity" boolean
);

COMMENT ON table student_courses IS 'The table list_courses';
COMMENT ON COLUMN student_courses.id_student IS 'ID student';
COMMENT ON COLUMN student_courses.id_course IS 'ID courses';
COMMENT ON COLUMN student_courses.date_start IS 'The beginning of the course';
COMMENT ON COLUMN student_courses.activity IS 'Is the course active';

CREATE TABLE IF NOT EXISTS reviews
(
    "id" bigint primary key not null,
    "id_student" bigint, FOREIGN KEY (id_student) REFERENCES students(id),
    "id_course" bigint,
    "review" text,
    "date" TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp
);

COMMENT ON table reviews IS 'The table reviews';
COMMENT ON COLUMN reviews.id IS 'ID review';
COMMENT ON COLUMN reviews.id_student IS 'This id student';
COMMENT ON COLUMN reviews.id_course IS 'This id course';
COMMENT ON COLUMN reviews.review IS 'This field review';