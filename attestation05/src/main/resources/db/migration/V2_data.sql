-- Вставка значений в таблицу Patients(Пациенты)

INSERT INTO "clinic".patients(id, fio, tel, address) VALUES (1, 'Иванов Иван Иванович', '+79876543210', 'ул.Мира, д.1');
INSERT INTO "clinic".patients(id, fio, tel, address) VALUES (2, 'Иванов Сергей Сергеевич', '+79876543211', 'ул.Дружбы, д.2');
INSERT INTO "clinic".patients(id, fio, tel, address) VALUES (3, 'Сидоров Сидор Сидорович', '+79876540010', 'ул.Счастья, д.3');
INSERT INTO "clinic".patients(id, fio, tel, address) VALUES (4, 'Петров Петр Петрович', '+79876541110', 'ул.Добра, д.4');
INSERT INTO "clinic".patients(id, fio, tel, address) VALUES (5, 'Сергеев Сергей Сергеевич', '+79876549910', 'ул.Радуги, д.5');

-- Вставка значений в таблицу Positions(Должность)

INSERT INTO "clinic".positions(id, position) VALUES (1, 'Врач-терапевт');
INSERT INTO "clinic".positions(id, position) VALUES (2, 'Врач-кардиолог');
INSERT INTO "clinic".positions(id, position) VALUES (3, 'Администратор');
INSERT INTO "clinic".positions(id, position) VALUES (4, 'Сетевой инженер');
INSERT INTO "clinic".positions(id, position) VALUES (5, 'Главный врач');

-- Вставка значений в таблицу Employees(Работники)

INSERT INTO "clinic".employees(id, fio, tel)VALUES (1, 'Иванова Инна Ивановна', '+79876543210');
INSERT INTO "clinic".employees(id, fio, tel) VALUES (2, 'Петрова Анна Петровна','+79870123456');
INSERT INTO "clinic".employees(id, fio, tel) VALUES (3, 'Сидорова Светлана Сидоровна','+79877531559');
INSERT INTO "clinic".employees(id, fio, tel) VALUES (4, 'Антонов Николай Аркадьевич','+79000001213');
INSERT INTO "clinic".employees(id, fio, tel) VALUES (5, 'Дмитриева Виктория Дмитриевна','+79000001213');

-- Вставка значений в таблицу Post(Занимаемая должность)

INSERT INTO "clinic".posts(id, id_pos, id_empl)VALUES (1, 1, 1);
INSERT INTO "clinic".posts(id, id_pos, id_empl) VALUES (2, 2, 2);
INSERT INTO "clinic".posts(id, id_pos, id_empl) VALUES (3, 3, 3);
INSERT INTO "clinic".posts(id, id_pos, id_empl) VALUES (4, 4, 4);
INSERT INTO "clinic".posts(id, id_pos, id_empl) VALUES (5, 5, 5);

-- Вставка значений в таблицу Appointments(Прием)

INSERT INTO "clinic".appointments(id, id_empl, id_pat, time, description, del) VALUES (1, 1, 5, '01.06.2025', 'Прием', false);
INSERT INTO "clinic".appointments(id, id_empl, id_pat, time, description, del) VALUES (2, 2, 4, '02.06.2025', 'Прием', false);
INSERT INTO "clinic".appointments(id, id_empl, id_pat, time, description, del) VALUES (3, 2, 1, '03.06.2025', 'Прием', false);
INSERT INTO "clinic".appointments(id, id_empl, id_pat, time, description, del) VALUES (4, 1, 2, '04.06.2025', 'Прием', false);
INSERT INTO "clinic".appointments(id, id_empl, id_pat, time, description, del) VALUES (5, 1, 3, '05.06.2025', 'Прием', false);