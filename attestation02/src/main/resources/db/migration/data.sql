
-- Вставка значений в таблицу Patients(Пациенты)

INSERT INTO "medikschema".patients(id, fio, tel, address) VALUES (1, 'Иванов Иван Иванович', '+79876543210', 'ул.Мира, д.1');
INSERT INTO "medikschema".patients(id, fio, tel, address) VALUES (2, 'Иванов Сергей Сергеевич', '+79876543211', 'ул.Дружбы, д.2');
INSERT INTO "medikschema".patients(id, fio, tel, address) VALUES (3, 'Сидоров Сидор Сидорович', '+79876540010', 'ул.Счастья, д.3');
INSERT INTO "medikschema".patients(id, fio, tel, address) VALUES (4, 'Петров Петр Петрович', '+79876541110', 'ул.Добра, д.4');
INSERT INTO "medikschema".patients(id, fio, tel, address) VALUES (5, 'Сергеев Сергей Сергеевич', '+79876549910', 'ул.Радуги, д.5');

-- Вставка значений в таблицу Positions(Должность)

INSERT INTO "medikschema".positions(id, position) VALUES (1, 'Врач-терапевт');
INSERT INTO "medikschema".positions(id, position) VALUES (2, 'Врач-кардиолог');
INSERT INTO "medikschema".positions(id, position) VALUES (3, 'Врач-эндокринолог');
INSERT INTO "medikschema".positions(id, position) VALUES (4, 'Врач-УЗИ');
INSERT INTO "medikschema".positions(id, position) VALUES (5, 'Врач-иммунолог');

-- Вставка значений в таблицу Doctors(Врачи)

INSERT INTO "medikschema".doctors(id, id_pos, fio_d, tel_d) VALUES (1, 1, 'Иванова Инна Ивановна','+79876543210');
INSERT INTO "medikschema".doctors(id, id_pos, fio_d, tel_d) VALUES (2, 2, 'Петрова Анна Петровна','+79870123456');
INSERT INTO "medikschema".doctors(id, id_pos, fio_d, tel_d) VALUES (3, 3, 'Сидорова Светлана Сидоровна','+79877531559');
INSERT INTO "medikschema".doctors(id, id_pos, fio_d, tel_d) VALUES (4, 4, 'Антонова Нина Аркадьевна','+79000001213');
INSERT INTO "medikschema".doctors(id, id_pos, fio_d, tel_d) VALUES (5, 5, 'Дмитриева Виктория Дмитриевна','+79000001213');

-- Вставка значений в таблицу Appointments(Прием)

INSERT INTO "medikschema".appointments(id, id_d, id_p, time, description) VALUES (1, 1, 5, '01.01.2025', 'Прием');
INSERT INTO "medikschema".appointments(id, id_d, id_p, time, description) VALUES (2, 2, 4, '02.01.2025', 'Прием');
INSERT INTO "medikschema".appointments(id, id_d, id_p, time, description) VALUES (3, 3, 1, '03.01.2025', 'Прием');
INSERT INTO "medikschema".appointments(id, id_d, id_p, time, description) VALUES (4, 4, 2, '04.01.2025', 'Прием');
INSERT INTO "medikschema".appointments(id, id_d, id_p, time, description) VALUES (5, 5, 3, '05.01.2025', 'Прием');