

INSERT INTO "student".courses(id, course) VALUES (1, 'Молекулярной биологии');
INSERT INTO "student".courses(id, course) VALUES (2, 'Патологической анатомии');
INSERT INTO "student".courses(id, course) VALUES (3, 'Судебной медицины');
INSERT INTO "student".courses(id, course) VALUES (4, 'Психиатрии');
INSERT INTO "student".courses(id, course) VALUES (5, 'Иммунологии');

INSERT INTO "student".students(id, fio, email) VALUES (1, 'Иванов Иван Иванович', 'ivanov@test.com');
INSERT INTO "student".students(id, fio, email) VALUES (2, 'Петров Петр Петрович', 'petrov@test.com');
INSERT INTO "student".students(id, fio, email) VALUES (3, 'Сидоров Сидр Сидорович', 'sidorov@test.com');

INSERT INTO "student".list_courses(id, id_fio, id_course) VALUES (1, 1, 1);
INSERT INTO "student".list_courses(id, id_fio, id_course) VALUES (2, 2, 2);
INSERT INTO "student".list_courses(id, id_fio, id_course) VALUES (3, 2, 2);
INSERT INTO "student".list_courses(id, id_fio, id_course) VALUES (4, 3, 4);
INSERT INTO "student".list_courses(id, id_fio, id_course) VALUES (5, 3, 5);
INSERT INTO "student".list_courses(id, id_fio, id_course) VALUES (6, 3, 3);