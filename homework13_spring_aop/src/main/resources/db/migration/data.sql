
INSERT INTO "student".students(id, fio, email) VALUES (1, 'Иванов Иван Иванович', 'ivanov@test.com');
INSERT INTO "student".students(id, fio, email) VALUES (2, 'Петров Петр Петрович', 'petrov@test.com');
INSERT INTO "student".students(id, fio, email) VALUES (3, 'Сидоров Сидр Сидорович', 'sidorov@test.com');

INSERT INTO "student".courses(id, name) VALUES (1, 'Гистология');
INSERT INTO "student".courses(id, name) VALUES (2, 'Общая анатомия');
INSERT INTO "student".courses(id, name) VALUES (3, 'Физиология');
INSERT INTO "student".courses(id, name) VALUES (4, 'Патологическая анатомия');
INSERT INTO "student".courses(id, name) VALUES (5, 'Фармакология');

INSERT INTO "student".list_courses(id, id_student, id_course) VALUES (1, 1, 1);
INSERT INTO "student".list_courses(id, id_student, id_course) VALUES (2, 1, 2);
INSERT INTO "student".list_courses(id, id_student, id_course) VALUES (3, 2, 2);
INSERT INTO "student".list_courses(id, id_student, id_course) VALUES (4, 2, 4);
INSERT INTO "student".list_courses(id, id_student, id_course) VALUES (5, 3, 1);
INSERT INTO "student".list_courses(id, id_student, id_course) VALUES (6, 3, 5);