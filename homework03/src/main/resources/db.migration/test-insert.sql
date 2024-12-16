

INSERT INTO "homeworkJavaEE".client(id, fio, tel, address) VALUES (1, 'Иванов Иван Иванович', '+79876543210', 'ул.Мира, д.1');
INSERT INTO "homeworkJavaEE".client(id, fio, tel, address) VALUES (2, 'Иванов Сергей Сергеевич', '+79876543211', 'ул.Дружбы, д.2');
INSERT INTO "homeworkJavaEE".client(id, fio, tel, address) VALUES (3, 'Сидоров Сидор Сидорович', '+79876540010', 'ул.Счастья, д.3');
INSERT INTO "homeworkJavaEE".client(id, fio, tel, address) VALUES (4, 'Петров Петр Петрович', '+79876541110', 'ул.Добра, д.4');
INSERT INTO "homeworkJavaEE".client(id, fio, tel, address) VALUES (5, 'Сергеев Сергей Сергеевич', '+79876549910', 'ул.Радуги, д.5');

INSERT INTO "homeworkJavaEE".doctor(id, fio_doctor, position, tel_doctor) VALUES (1, 'Мирнова Мира Мировна', 'Врач-терапевт','+79870003210');
INSERT INTO "homeworkJavaEE".doctor(id, fio_doctor, position, tel_doctor) VALUES (2, 'Иванова Алена Ивановна', 'Врач-кардиолог','+79870010010');
INSERT INTO "homeworkJavaEE".doctor(id, fio_doctor, position, tel_doctor) VALUES (3, 'Петрова Анна Сергеевна', 'Врач-эндокринолог','+79870023220');
INSERT INTO "homeworkJavaEE".doctor(id, fio_doctor, position, tel_doctor) VALUES (4, 'Сидорова Надежда Михайловна', 'Врач-УЗИ','+79870004240');
INSERT INTO "homeworkJavaEE".doctor(id, fio_doctor, position, tel_doctor) VALUES (5, 'Петрова Любовь Ивановна', 'Главный врач','+79870005251');

INSERT INTO "homeworkJavaEE".appointment(id, id_doc, id_client, time, description) VALUES ('1', 1, 1, '01.01.2025', 'Прием');
INSERT INTO "homeworkJavaEE".appointment(id, id_doc, id_client, time, description) VALUES ('2', 2, 2, '02.01.2025', 'Прием');
INSERT INTO "homeworkJavaEE".appointment(id, id_doc, id_client, time, description) VALUES ('3', 3, 3, '01.01.2025', 'Прием');