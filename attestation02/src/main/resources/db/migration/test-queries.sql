
-- CRUD запросы к таблице Patients

SELECT address FROM patients WHERE fio='Петров Петр Петрович';
UPDATE patients SET tel='+79998887766', address='ул.Простая, д.3, кв.4' WHERE fio='Сергеев Сергей Сергеевич';
INSERT INTO patients (id, fio, tel, address) VALUES (8, 'Никифоров Иван Дмитриевич', '+79990007755', 'пер. НовыйГород, д.2, кв.5');
DELETE FROM patients  WHERE fio='Никифоров Иван Дмитриевич';

-- CRUD запросы к таблице Doctors

SELECT position FROM positions WHERE id=(SELECT id_pos FROM doctors WHERE fio_d='Петрова Анна Петровна');
UPDATE doctors SET tel_d='+79001112233' WHERE fio_d='Петрова Анна Петровна';
INSERT INTO doctors (id, id_pos, fio_d, tel_d) VALUES (7, 3, 'Нагорная Анна Сергеевна', '+79990008866');
DELETE FROM doctors  WHERE fio_d='Нагорная Анна Сергеевна';

-- CRUD запросы к таблице Appointments

SELECT time FROM appointments WHERE id_d=(SELECT id_pos FROM doctors WHERE fio_d='Петрова Анна Петровна');
UPDATE appointments SET time='07.01.2025' WHERE id_d=(SELECT id FROM doctors WHERE fio_d='Петрова Анна Петровна');
INSERT INTO appointments (id, id_d, id_p, time, description) VALUES (8, 3, 1, '08.01.2025', 'прием по записи');
DELETE FROM appointments WHERE id_p=(SELECT id FROM patients WHERE fio='Сидоров Сидор Сидорович');

-- CRUD запросы к таблице Positions

SELECT * FROM positions;
UPDATE positions SET position='Врач-невролог' WHERE id=2;
INSERT INTO positions(id, position) VALUES (8, 'Врач-психиатр');
DELETE FROM positions WHERE position='Врач-психиатр';