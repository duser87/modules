package ru.innopolis.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.JDBCTemplateDriver;
import ru.innopolis.model.Doctor;
import ru.innopolis.repository.DoctorRepository;

import java.util.List;

public class DoctorRepoImpl implements DoctorRepository {

    JdbcTemplate jdbcTemplateDriver = JDBCTemplateDriver.jdbcTemplate();

    private static final String GET_DOC ="SELECT * FROM doctors";

    private static final String UPDATE_DOC ="UPDATE doctors SET tel_d = ? WHERE fio_d = ?";

    private static final String INSERT_DOC="INSERT INTO doctors (id, id_pos, fio_d, tel_d) VALUES (?, (SELECT id FROM positions WHERE position = ?), ?, ?)";

    private static final String DELETE_DOC ="DELETE FROM doctors  WHERE fio_d = ?";

    @Override
    public List<Doctor> allFind() {
        return jdbcTemplateDriver.query(GET_DOC, doctorRowMapper);
    }

    @Override
    public void addDoc(Long id,String pos, String fio_d, String tel_d) {

        jdbcTemplateDriver.update(INSERT_DOC, id, pos, fio_d, tel_d);

    }

    @Override
    public void update(String fio_d, String tel_d) {

        jdbcTemplateDriver.update(UPDATE_DOC, fio_d, tel_d);

    }

    @Override
    public void delete(String fio_d) {

        jdbcTemplateDriver.update(DELETE_DOC, fio_d);

    }

    private static final RowMapper<Doctor> doctorRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        Long id_pos = row.getLong("id_pos");
        String fio_d = row.getString("fio_d");
        String tel_d = row.getString("tel_d");

        return new Doctor(id, id_pos, fio_d, tel_d);

    };

}

