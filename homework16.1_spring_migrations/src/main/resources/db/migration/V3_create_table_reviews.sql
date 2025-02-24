
CREATE TABLE IF NOT EXISTS reviews
(
    "id" bigint primary key not null,
    "id_student" bigint, FOREIGN KEY (id_student) REFERENCES students(id),
    "id_course" bigint, FOREIGN KEY (id_course) REFERENCES courses(id),
    "review" text,
    "date" TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp
);

COMMENT ON table reviews IS 'The table reviews';
COMMENT ON COLUMN reviews.id IS 'ID review';
COMMENT ON COLUMN reviews.id_student IS 'This id student';
COMMENT ON COLUMN reviews.id_course IS 'This id course';
COMMENT ON COLUMN reviews.review IS 'This field review';