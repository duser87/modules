package ru.innopolis.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.JDBCTemplateDriver;
import ru.innopolis.model.Patient;
import ru.innopolis.model.Position;
import ru.innopolis.repository.PositionRepository;

import java.util.List;

public class PositionRepoImpl implements PositionRepository {

    JdbcTemplate jdbcTemplateDriver = JDBCTemplateDriver.jdbcTemplate();

    private static final String GET_POS ="SELECT * FROM positions";

    private static final String UPDATE_POS ="UPDATE positions SET position = ? WHERE id = ?";

    private static final String INSERT_POS="INSERT INTO positions (id, position) VALUES (?, ?)";

    private static final String DELETE_POS ="DELETE FROM positions  WHERE position = ?";

    @Override
    public List<Position> allFind() {
        return jdbcTemplateDriver.query(GET_POS, positionRowMapper);
    }

    @Override
    public void addPos(Long id, String pos) {

        jdbcTemplateDriver.update(INSERT_POS, id, pos);

    }

    @Override
    public void update(Long id, String pos) {

        jdbcTemplateDriver.update(UPDATE_POS, pos, id);

    }

    @Override
    public void delete(String pos) {

        jdbcTemplateDriver.update(DELETE_POS, pos);

    }

    private static final RowMapper<Position> positionRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        String position = row.getString("position");


        return new Position(id, position);

    };

}
