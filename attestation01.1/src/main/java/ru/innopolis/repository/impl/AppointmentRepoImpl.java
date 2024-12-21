package ru.innopolis.repository.impl;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.JDBCTemplateDriver;
import ru.innopolis.model.Appointment;
import ru.innopolis.repository.AppointmentRepository;

import java.util.List;

public class AppointmentRepoImpl implements AppointmentRepository {

    JdbcTemplate jdbcTemplateDriver = JDBCTemplateDriver.jdbcTemplate();

    private static final String GET_ALL ="SELECT * FROM appointments";

    private static final String UPDATE_APP ="UPDATE appointments SET time = ? , description = ? WHERE id_p = (SELECT id FROM patients WHERE fio = ?)";

    private static final String INSERT_APP="INSERT INTO appointments (id, id_d, id_p, time, description) VALUES (?, (SELECT id FROM doctors WHERE fio_d = ?), (SELECT id FROM patients WHERE fio = ?), ?, ?)";

    private static final String DELETE_APP ="DELETE FROM appointments WHERE id_p = (SELECT id FROM patients WHERE fio = ?)";

    @Override
    public List<Appointment> allFind() {
        return jdbcTemplateDriver.query(GET_ALL, appointmentRowMapper);
    }

    @Override
    public void addApp(Long id, String fio_d, String fio_p, String time, String desc) {

        jdbcTemplateDriver.update(INSERT_APP, id, fio_d, fio_p, time, desc);

    }

    @Override
    public void update(String fio_p, String time, String desc) {

        jdbcTemplateDriver.update(UPDATE_APP, fio_p, time, desc);

    }

    @Override
    public void delete(String fio_p) {

        jdbcTemplateDriver.update(DELETE_APP, fio_p);

    }

    private static final RowMapper<Appointment> appointmentRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        Long id_d = row.getLong("id_d");
        Long id_p = row.getLong("id_p");
        String time = row.getString("time");
        String desc = row.getString("description");

        return new Appointment(id, id_d, id_p, time, desc);

    };

}
