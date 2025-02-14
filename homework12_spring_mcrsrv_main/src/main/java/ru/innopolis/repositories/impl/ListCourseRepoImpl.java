package ru.innopolis.repositories.impl;

import jakarta.validation.constraints.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import ru.innopolis.config.JDBCTemplateConfig;
import ru.innopolis.entities.ListCoursesEntity;
import ru.innopolis.repositories.ListCourseRepository;

import java.util.List;

@Repository
public class ListCourseRepoImpl implements ListCourseRepository {

    JdbcTemplate template = JDBCTemplateConfig.jdbcTemplate();

    private static final String CREATE = "INSERT INTO students.student_courses (id, id_student, id_course, activity) VALUES (?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM students.student_courses WHERE id_student=? AND id_course=?";
    private static final String FIND_ALL = "SELECT * FROM students.student_courses";
    private static final String FIND_MAX_ID ="SELECT id FROM students.student_courses WHERE id = (SELECT MAX(id) FROM students.student_courses)";

    @Override
    public void create(ListCoursesEntity list) {
        if(list.getId() == null){
            var result = findMaxId() + 1L;
            template.update(CREATE, result, list.getId_student(), list.getId_course(), list.getActivity());
        }
        else{
            template.update(CREATE, list.getId(), list.getId_student(), list.getId_course(), list.getActivity());
        }
    }

    @Override
    public List<ListCoursesEntity> findListCoursesById(Long id) {
        return (template.query(FIND_ALL, listCoursesRowMapper)).stream().filter(x -> x.getId_student().equals(id)).toList();
    }

    @Override
    public String delete(Long id_student, Long id_course) {
        template.update(DELETE, id_student, id_course);
        return "Запись с ID=" + id_student + " удалена!";
    }

    private Long findMaxId(){
        return template.queryForObject(FIND_MAX_ID, Long.class);
    }

    private static final RowMapper<ListCoursesEntity> listCoursesRowMapper = (row, rowNumber) -> {
        Long id = row.getLong("id");
        Long id_student = row.getLong("id_student");
        Long id_course = row.getLong("id_course");
        String start_date = row.getString("start_date");
        Boolean activity = row.getBoolean("activity");
        return new ListCoursesEntity(id, id_student, id_course, start_date, activity);

    };
}
