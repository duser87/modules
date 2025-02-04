package ru.innopolis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import ru.innopolis.config.JDBCTemplateConfig;
import ru.innopolis.models.ListCourses;

import java.util.List;
import java.util.Optional;

@Repository
public class ListCoursesRepository {


    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateConfig.jdbcTemplate());

    private static final String CREATE = "INSERT INTO student.list_courses (id, id_student, id_course) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE student.list_courses SET id_student=?, id_course=? WHERE id=?";
    private static final String DELETE = "DELETE FROM student.list_courses WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM student.list_courses WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM student.list_courses";

    public Optional<ListCourses> create(Long id, Long id_student, Long id_course) {
        template.update(CREATE, id, id_student, id_course);
        return findById(id);
    }

    public Optional<ListCourses> update(Long id, Long id_student, Long id_course){
        template.update(UPDATE, id_student, id_course, id);
        return findById(id);
    }


    public String delete(Long id) {
        template.update(DELETE, id);
        return "Запись с ID=" + id + " удалена!";
    }


    public Optional<ListCourses> findById(Long id) {
        return templateClient.sql(FIND_BY_ID).param(id).query(ListCourses.class).optional();
    }

    public List<ListCourses> findListCourses(Long id_student){
        return (template.query(FIND_ALL, listCoursesRowMapper)).stream().filter(x -> x.getId_student().equals(id_student)).toList();
    }

    private static final RowMapper<ListCourses> listCoursesRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        Long id_student = row.getLong("id_student");
        Long id_course = row.getLong("id_course");

        return new ListCourses(id, id_student, id_course);

    };

}
