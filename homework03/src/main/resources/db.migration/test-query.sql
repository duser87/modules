

SELECT * FROM "homeworkJavaEE".client;
SELECT * FROM "homeworkJavaEE".doctor;
SELECT fio_doctor FROM "homeworkJavaEE".doctor WHERE position = 'Врач-УЗИ';
SELECT fio FROM "homeworkJavaEE".client WHERE id = (SELECT id_client FROM "homeworkJavaEE".appointment WHERE id = 3);
