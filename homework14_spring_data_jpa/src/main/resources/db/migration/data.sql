

INSERT INTO student.students(id, fio, email, age) VALUES (1,  'Иванов Иван Иванович', 'ivanov@test.com', 25);
INSERT INTO student.students(id, fio, email, age) VALUES (2,  'Петров Петр Петрович', 'petrov@test.com', 37);
INSERT INTO student.students(id, fio, email, age) VALUES (3,  'Сидоров Сидор Сидорович', 'sidorov@test.com', 49);

INSERT INTO student.courses(id, name, activity) VALUES (1,  'Патологическая анатомия', true);
INSERT INTO student.courses(id, name, activity) VALUES (2,  'Физиология', false);
INSERT INTO student.courses(id, name, activity) VALUES (3,  'Гистология', true);
INSERT INTO student.courses(id, name, activity) VALUES (4,  'Общая хирургия', true);
INSERT INTO student.courses(id, name, activity) VALUES (5,  'Фармакология', false);
INSERT INTO student.courses(id, name, activity) VALUES (6,  'Судебная медицина', true);

INSERT INTO student.list_courses(id, id_student, id_course, activity) VALUES (1,  1, 1, true);
INSERT INTO student.list_courses(id, id_student, id_course, activity) VALUES (2,  1, 2, true);
INSERT INTO student.list_courses(id, id_student, id_course, activity) VALUES (3,  2, 3, true);
INSERT INTO student.list_courses(id, id_student, id_course, activity) VALUES (4,  2, 4, true);
INSERT INTO student.list_courses(id, id_student, id_course, activity) VALUES (5,  3, 5, true);
INSERT INTO student.list_courses(id, id_student, id_course, activity) VALUES (6,  3, 1, true);