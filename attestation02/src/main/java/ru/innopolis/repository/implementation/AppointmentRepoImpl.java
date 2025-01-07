package ru.innopolis.repository.implementation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import ru.innopolis.App;
import ru.innopolis.JDBCTemplateDriver;
import ru.innopolis.model.Appointment;
import ru.innopolis.repository.AppointmentRepository;

import java.util.List;
import java.util.Optional;

public class AppointmentRepoImpl implements AppointmentRepository {

    JdbcTemplate template = JDBCTemplateDriver.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateDriver.jdbcTemplate());

    private static final String CREATE = "INSERT INTO appointments (id, id_d, id_p, time, description) VALUES (?, (SELECT id FROM doctors WHERE fio_d = ?), (SELECT id FROM patients WHERE fio = ?), ?, ?)";

    private static final String FINDBYID = "SELECT * FROM appointments WHERE id = ?";

    private static final String FINDALL = "SELECT * FROM appointments";

    private static final String UPDATE = "UPDATE appointments SET id_d = ? , id_p = ? , time = ? , description = ? WHERE id = ?";

    private static final String DELETEBYID = "DELETE FROM appointments WHERE id = ?";

    private static final String DELETEALL = "DELETE FROM appointments";

    private static final String COUNTBYID = "SELECT COUNT(*) FROM appointments WHERE id_d = ?";

    @Override
    public Boolean create(Long id, String fio_d, String fio_p, String t, String desc) {

        Optional<Appointment> appointment = templateClient.sql(CREATE)
                .param(id)
                .param(fio_d)
                .param(fio_p)
                .param(t)
                .param(desc)
                .query(Appointment.class)
                .optional();

        return appointment.isPresent();
    }

    @Override
    public Optional<Appointment> findById(Long id) {

        return Optional.of(templateClient.sql(FINDBYID)
                .param(id)
                .query(Appointment.class)
                .optional().orElseThrow());

    }

    @Override
    public List<Appointment> findAll() {

        return template.query(FINDALL, appointmentRowMapper);

    }

    @Override
    public String update(Long id, String fio_d, String fio_p, String time, String desc) {

        Long rowCount = 0L;

        rowCount = template.queryForObject("SELECT COUNT(*) FROM appointments WHERE id = ?", Long.class, id);

        Optional.ofNullable(rowCount).ifPresentOrElse(

                (X) -> {

                    template.update(UPDATE, fio_d, fio_p, time, desc, id);

                },

                () -> {

                    template.update(CREATE, id, fio_d, fio_p, time, desc);

                }

        );

        return rowCount > 0 ? "Обновлена запись с ID = " + id.toString() : "Добавлена запись с ID = " + id.toString();
    }

    @Override
    public void deleteById(Long id) {

        Optional<Appointment> x = templateClient.sql(DELETEBYID)
                .param(id)
                .query(Appointment.class)
                .optional();

        x.orElseThrow();

    }

    @Override
    public String deleteAll() {
        return "";
    }

    @Override
    public Long countById(Long id) {
        return 0L;
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
