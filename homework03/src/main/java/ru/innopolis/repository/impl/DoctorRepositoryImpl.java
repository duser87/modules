package ru.innopolis.repository.impl;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.config.JDBCTamplateBuild;
import ru.innopolis.entity.Doctor;
import ru.innopolis.repository.DoctorRepository;
import java.util.List;

public class DoctorRepositoryImpl implements DoctorRepository {

    private final JdbcTemplate jdbcTamplaeBuild = JDBCTamplateBuild.jdbcTamplate();

    private static final String GET_ALL =  "SELECT * FROM doctor";

    private static final String UPDATE_POSITION_DOCTOR =  "UPDATE doctor SET position = ? , tel_doctor = ? WHERE fio_doctor = ?";

    private static final String INSERT_DOCTOR ="INSERT INTO doctor (id, fio_doctor, position, tel_doctor) VALUES (?, ?, ?, ?)";

    private static final String DELETE_DOCTOR ="DELETE FROM doctor WHERE fio_doctor = ?";

    @Override
    public List<Doctor> getAll() {
        return jdbcTamplaeBuild.query(GET_ALL, doctorRowMapper);
    }

    @Override
    public void updateDoctor(String position, String tel_doctor, String fio_doctor) {

        jdbcTamplaeBuild.update(UPDATE_POSITION_DOCTOR, position, tel_doctor, fio_doctor);

    }

    @Override
    public void deleteDoctor(String fio) {

        jdbcTamplaeBuild.update(DELETE_DOCTOR, fio);

    }

    @Override
    public void addDoctor(Long id, String fio_doctor, String position, String tel_doctor) {
        jdbcTamplaeBuild.update(INSERT_DOCTOR, id, fio_doctor, position, tel_doctor);
    }


    private static final RowMapper<Doctor> doctorRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        String fio_doc = row.getString("fio_doctor");
        String position_doc = row.getString("position");
        String tel_doc = row.getString("tel_doctor");

        return new Doctor(id, fio_doc, position_doc, tel_doc);

    };

}
