package ru.innopolis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import ru.innopolis.config.JDBCTemplateConfig;
import ru.innopolis.models.Course;

import java.util.Optional;

@Repository
public class CourseRepository {

    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateConfig.jdbcTemplate());

    private static final String CREATE = "INSERT INTO student.courses (id, name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE student.courses SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM student.courses WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM student.courses WHERE id=?";
    private static final String FIND_ID = "SELECT id FROM student.courses WHERE name=?";

    public Optional<Course> create(Long id, String name) {
        template.update(CREATE, id, name);
        return findById(id);
    }

    public Optional<Course> update(Long id, String name){
        template.update(UPDATE, name, id);
        return findById(id);
    }

    public String delete(Long id) {
        template.update(DELETE, id);
        return "Запись с ID=" + id + " удалена!";
    }

    public Optional<Course> findById(Long id) {
        return templateClient.sql(FIND_BY_ID).param(id).query(Course.class).optional();
    }

    public Optional<Long> findId(String name){
        return templateClient.sql(FIND_ID).param(name).query(Long.class).optional();
    }

}
