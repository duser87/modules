package ru.innopolis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import ru.innopolis.config.JDBCTemplateConfig;
import ru.innopolis.models.Student;

import java.util.Optional;

@Repository
public class StudentRepository{

    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateConfig.jdbcTemplate());

    private static final String CREATE = "INSERT INTO student.students (id, fio, email) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE student.students SET fio=? , email=? WHERE id=?";
    private static final String DELETE = "DELETE FROM student.students WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM student.students WHERE id=?";

    public Optional<Student> create(Long id, String fio, String email) {
        template.update(CREATE, id, fio, email);
        return findById(id);
    }

    public Optional<Student> update(Long id, String fio, String email) {
        template.update(UPDATE, fio, email, id);
        return findById(id);
    }


    public String delete(Long id) {
        template.update(DELETE, id);
        return "Запись с ID=" + id + " удалена!";
    }


    public Optional<Student> findById(Long id) {
        return templateClient.sql(FIND_BY_ID).param(id).query(Student.class).optional();
    }
}
