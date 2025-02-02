package ru.innopolis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import ru.innopolis.config.JDBCTemplateConfig;
import ru.innopolis.models.Course;
import ru.innopolis.models.ListCourses;

import java.util.List;
import java.util.Optional;

@Repository
public class ListCoursesRepository{

    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateConfig.jdbcTemplate());

    private static final String CREATE = "INSERT INTO student.list_courses (id, id_fio, id_course) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM student.list_courses WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM student.list_courses WHERE id=?";

    public void create(Long id, String course) {
        template.update(CREATE, id, course);
    }

    public String delete(Long id) {
        template.update(DELETE, id);
        return "Запись с ID=" + id + " удалена!";
    }

    public List<ListCourses> findById(Long id_fio) {
        List<ListCourses> result = template.query("SELECT * FROM student.list_courses", listCourseRowMapper);
        return result.stream().filter(n -> n.getId().equals(id_fio)).toList();
    }

    private static final RowMapper<ListCourses> listCourseRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        Long id_fio = row.getLong("id_fio");
        Long id_course = row.getLong("id_course");

        return new ListCourses(id, id_fio, id_course);

    };

}
