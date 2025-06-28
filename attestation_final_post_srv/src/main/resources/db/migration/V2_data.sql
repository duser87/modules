-- Вставка значений в таблицу Positions(Должность)

INSERT INTO "post_service".positions(id, position) VALUES (1, 'Врач-терапевт');
INSERT INTO "post_service".positions(id, position) VALUES (2, 'Врач-кардиолог');
INSERT INTO "post_service".positions(id, position) VALUES (3, 'Администратор');
INSERT INTO "post_service".positions(id, position) VALUES (4, 'Сетевой инженер');
INSERT INTO "post_service".positions(id, position) VALUES (5, 'Главный врач');

-- Вставка значений в таблицу Post(Занимаемая должность)

INSERT INTO "post_service".posts(id, id_pos, id_empl)VALUES (1, 1, 1);
INSERT INTO "post_service".posts(id, id_pos, id_empl) VALUES (2, 2, 2);
INSERT INTO "post_service".posts(id, id_pos, id_empl) VALUES (3, 3, 3);
INSERT INTO "post_service".posts(id, id_pos, id_empl) VALUES (4, 4, 4);
INSERT INTO "post_service".posts(id, id_pos, id_empl) VALUES (5, 5, 5);