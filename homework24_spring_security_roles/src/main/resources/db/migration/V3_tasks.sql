CREATE TABLE IF NOT EXISTS tasks
(
    "id" bigint primary key not null,
   -- "id_student" bigint, FOREIGN KEY (id_student) REFERENCES students(id),
    "name" varchar,
    "description" varchar,
    "start_date" TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp
);

COMMENT ON table tasks IS 'The table users';
COMMENT ON COLUMN tasks.name IS 'Name is task';
COMMENT ON COLUMN tasks.description IS 'Description task';
COMMENT ON COLUMN tasks.start_date IS 'Time';