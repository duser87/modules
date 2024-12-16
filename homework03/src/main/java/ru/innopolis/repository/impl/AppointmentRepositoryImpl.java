package ru.innopolis.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.config.JDBCTamplateBuild;
import ru.innopolis.entity.Appointment;
import ru.innopolis.entity.Client;
import ru.innopolis.repository.AppointmentRepository;

import java.util.List;

public class AppointmentRepositoryImpl implements AppointmentRepository {

    JdbcTemplate jdbcTamplaeBuild = JDBCTamplateBuild.jdbcTamplate();

    private static final String GET_ALL ="SELECT * FROM appointment";

    private static final String UPDATE_APP ="UPDATE appointment SET time = ? , description = ? WHERE id_client = (SELECT id FROM client WHERE fio = ?)";

    private static final String INSERT_APP="INSERT INTO appointment (id, id_doc, id_client, time, description) VALUES (?, (SELECT id FROM doctor WHERE fio_doctor = ?), (SELECT id FROM client WHERE fio = ?), ?, ?)";

    private static final String DELETE_APP ="DELETE FROM appointment WHERE id_client = (SELECT id FROM client WHERE fio = ?)";

    @Override
    public List<Appointment> getAll() {

        return jdbcTamplaeBuild.query(GET_ALL, appointmentRowMapper);

    }

    @Override
    public void updateAppointment(String time, String desc, String fio_client) {

        jdbcTamplaeBuild.update(UPDATE_APP, time, desc, fio_client);

    }

    @Override
    public void addAppoint(Long id, String fio_doctor, String fio_client, String time, String desc) {

        jdbcTamplaeBuild.update(INSERT_APP, id, fio_doctor, fio_client, time, desc);

    }

    @Override
    public void deleteAppoint(String fio) {

        jdbcTamplaeBuild.update(DELETE_APP, fio);

    }

    private static final RowMapper<Appointment>  appointmentRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        Long id_doc = row.getLong("id_doc");
        Long id_client = row.getLong("id_client");
        String time = row.getString("time");
        String desc = row.getString("description");

        return new Appointment(id, id_doc, id_client, time, desc);

    };

}

