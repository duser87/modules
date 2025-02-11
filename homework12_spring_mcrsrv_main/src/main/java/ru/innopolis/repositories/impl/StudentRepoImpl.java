package ru.innopolis.repositories.impl;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import ru.innopolis.config.JDBCTemplateConfig;
import ru.innopolis.entities.StudentEntity;
import ru.innopolis.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepoImpl implements StudentRepository {

    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateConfig.jdbcTemplate());

    private static final String CREATE = "INSERT INTO students.students (id, fio, email) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE students.students SET fio=? , email=? WHERE id=?";
    private static final String DELETE = "DELETE FROM students.students WHERE id=?";
    private static final String FIND_BY_FIO = "SELECT * FROM students.students WHERE fio=?";
   // private static final String FIND_BY_ID = "SELECT * FROM students.students WHERE id=?";
    private static final String FIND_MAX_ID ="SELECT id FROM students.students WHERE id = (SELECT MAX(id) FROM students.students)";

    @Override
    public void create(StudentEntity student) {
        Long result = findMaxId();
        template.update(CREATE, result+1L, student.getFio(), student.getEmail());
    }

    @Override
    public void update(StudentEntity student) {
        Long result = findMaxId();
        template.update(UPDATE, result+1L, student.getFio(), student.getEmail());
    }

    @Override
    public Optional<StudentEntity> findByName(String fio) {
        return templateClient.sql(FIND_BY_FIO).param(fio).query(StudentEntity.class).optional();
    }

    @Override
    public String delete(Long id) {
        template.update(DELETE, id);
        return "Запись с ID=" + id + " удалена!";
    }

    private Long findMaxId(){
        return template.queryForObject(FIND_MAX_ID, Long.class);
    }
}
