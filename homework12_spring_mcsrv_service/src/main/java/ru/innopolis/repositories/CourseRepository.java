package ru.innopolis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import ru.innopolis.config.JDBCTemplateConfigService;
import ru.innopolis.dto.CourseResponse;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {

    JdbcTemplate template = JDBCTemplateConfigService.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateConfigService.jdbcTemplate());

    private static final String FIND_BY_ID = "SELECT * FROM courses.courses WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM courses.courses";

    public Optional<CourseResponse> getCourse(Long id){
        return templateClient.sql(FIND_BY_ID).param(id).query(CourseResponse.class).optional();
    }

    public List<CourseResponse> getListCourses(){
        return template.query(FIND_ALL, coursesResponsesRowMapperRowMapper).stream().toList();
    }

    private final RowMapper<CourseResponse> coursesResponsesRowMapperRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        String name = row.getString("name");

        return new CourseResponse(id, name);

    };

}
