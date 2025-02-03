package ru.innopolis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import ru.innopolis.config.JDBCTemplateConfig;
import ru.innopolis.models.Course;
import ru.innopolis.models.Student;

import java.util.Optional;

@Repository
public class CourseRepository {

    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateConfig.jdbcTemplate());

    private static final String CREATE = "INSERT INTO student.courses (id, course) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE student.courses SET course=? WHERE id=?";
    private static final String DELETE = "DELETE FROM student.courses WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM student.courses WHERE id=?";

    public Optional<Course> create(Long id, String course) {
        template.update(CREATE, id, course);
        return findById(id);
    }

    public Optional<Course> update(Long id, String course) {
        template.update(UPDATE, course, id);
        return findById(id);
    }


    public String delete(Long id) {
        template.update(DELETE, id);
        return "Запись с ID=" + id + " удалена!";
    }


    public Optional<Course> findById(Long id) {
        return templateClient.sql(FIND_BY_ID).param(id).query(Course.class).optional();
    }

}
