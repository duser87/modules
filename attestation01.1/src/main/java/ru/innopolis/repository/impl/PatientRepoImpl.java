package ru.innopolis.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.JDBCTemplateDriver;
import ru.innopolis.model.Doctor;
import ru.innopolis.model.Patient;
import ru.innopolis.repository.PatientRepository;

import java.util.List;

public class PatientRepoImpl implements PatientRepository {

    JdbcTemplate jdbcTemplateDriver = JDBCTemplateDriver.jdbcTemplate();

    private static final String GET_PAT ="SELECT * FROM patients";

    private static final String UPDATE_PAT ="UPDATE patients SET tel = ?, address = ? WHERE fio = ?";

    private static final String INSERT_PAT="INSERT INTO patients (id, fio, tel, address) VALUES (?, ?, ?, ?)";

    private static final String DELETE_PAT ="DELETE FROM patients  WHERE fio = ?";

    @Override
    public List<Patient> allFind() {
        return jdbcTemplateDriver.query(GET_PAT, patientRowMapper);
    }

    @Override
    public void addPat(Long id, String fio, String tel, String address) {

        jdbcTemplateDriver.update(INSERT_PAT, id, fio, tel, address);

    }

    @Override
    public void update(String tel, String address, String fio) {

        jdbcTemplateDriver.update(UPDATE_PAT, tel, address, fio);

    }

    @Override
    public void delete(String fio) {

        jdbcTemplateDriver.update(DELETE_PAT, fio);

    }

    private static final RowMapper<Patient> patientRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        String fio = row.getString("fio");
        String tel = row.getString("tel");
        String address = row.getString("address");

        return new Patient(id, fio, tel, address);

    };

}
