
INSERT INTO students.students(id, fio, email) VALUES (1,  'Иванов Иван Иванович', 'ivanov@test.com');
INSERT INTO students.students(id, fio, email) VALUES (2,  'Петров Петр Петрович', 'petrov@test.com');
INSERT INTO students.students(id, fio, email) VALUES (3,  'Сидоров Сидор Сидорович', 'sidorov@test.com');

INSERT INTO students.student_courses(id, id_student, id_course, activity) VALUES (1,  1, 1, 0);
INSERT INTO students.student_courses(id, id_student, id_course, activity) VALUES (2,  1, 2, 0);
INSERT INTO students.student_courses(id, id_student, id_course, activity) VALUES (3,  2, 3, 0);
INSERT INTO students.student_courses(id, id_student, id_course, activity) VALUES (4,  2, 4, 0);
INSERT INTO students.student_courses(id, id_student, id_course, activity) VALUES (5,  3, 5, 0);
INSERT INTO students.student_courses(id, id_student, id_course, activity) VALUES (6,  3, 1, 0);

