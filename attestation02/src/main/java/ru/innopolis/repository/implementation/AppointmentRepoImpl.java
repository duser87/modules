package ru.innopolis.repository.implementation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import ru.innopolis.JDBCTemplateDriver;
import ru.innopolis.exceptions.ErrorWritingDbById;
import ru.innopolis.exceptions.NoRecordRowDB;
import ru.innopolis.model.Appointment;
import ru.innopolis.repository.AppointmentRepository;

import java.util.List;
import java.util.Optional;

public class AppointmentRepoImpl implements AppointmentRepository   {

    JdbcTemplate template = JDBCTemplateDriver.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateDriver.jdbcTemplate());

    private static final String CREATE = "INSERT INTO appointments (id, id_d, id_p, time, description) VALUES (?, (SELECT id FROM doctors WHERE fio_d = ?), (SELECT id FROM patients WHERE fio = ?), ?, ?)";

    private static final String FINDBYID = "SELECT * FROM appointments WHERE id = ?";

    private static final String FINDALL = "SELECT * FROM appointments";

    private static final String UPDATE = "UPDATE appointments SET id_d = (SELECT id FROM doctors WHERE fio_d = ?) , id_p = (SELECT id FROM patients WHERE fio = ?) , time = ? , description = ? WHERE id = ?";

    private static final String DELETEBYID = "DELETE FROM appointments WHERE id = ?";

    private static final String DELETEALL = "DELETE FROM appointments";

    @Override
    public void create(Long id, String fio_d, String fio_p, String t, String desc) throws ErrorWritingDbById{

        try{

            template.update(CREATE, id, fio_d, fio_p, t, desc);

        }
        catch (Exception e){

            throw new ErrorWritingDbById(" -!- Не удалось создать запись с ID = " + id + " . Возможно запись с таким ID уже существует");

        }

    }


    @Override
    public Optional<Appointment> findById(Long id) {

        return templateClient.sql(FINDBYID)
                .param(id)
                .query(Appointment.class)
                .optional();

    }

    @Override
    public List<Appointment> findAll() {

        return template.query(FINDALL, appointmentRowMapper);

    }


    @Override
    public String update(Object id, Object fio_d, Object fio_p, Object time, Object desc) throws IllegalArgumentException{

        Long rowCount;
        String str;

        Optional<Boolean> id_p = Optional.of(id instanceof Long);
        if(!id_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра id не соответствует заданному"); }

        Optional<Boolean> fio_p_p = Optional.of(fio_p instanceof String);
        if(!fio_p_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра fio_p не соответствует заданному"); }

        Optional<Boolean> fio_d_p = Optional.of(fio_d instanceof String);
        if(!fio_d_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра fio_d_p не соответствует заданному"); }

        Optional<Boolean> time_p = Optional.of(time instanceof String);
        if(!time_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра fio_d_p не соответствует заданному"); }

        Optional<Boolean> desc_p = Optional.of(desc instanceof String);
        if(!desc_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра fio_d_p не соответствует заданному"); }


        rowCount = template.queryForObject("SELECT COUNT(*) FROM appointments WHERE id = ?", Long.class, id);

        if(rowCount != 0L){

            template.update(UPDATE, fio_d, fio_p, time, desc, id);
            str = "Обновлена запись с ID = " + id;

        }
        else {

            template.update(CREATE, id, fio_d, fio_p, time, desc);
            str = "Добавлена запись с ID = " + id.toString();

        }

        return str;
    }

    @Override
    public String deleteById(Long id) throws NoRecordRowDB {

        String str;

        List<Appointment> listApp = template.query(FINDALL, appointmentRowMapper);

        Optional<Long> result = Optional.of(listApp.stream().filter(el -> el.getId().equals(id)).count());

        if(result.get() != 0){

            template.update(DELETEBYID, id);

            str = "Запись с ID = " + id + " удалена...";

        }
        else {

            throw  new NoRecordRowDB("-!- Запись с ID = " + id + " нет!");

        }

        return str;

    }

    @Override
    public String deleteAll() {

        template.update(DELETEALL);

        return "Все записи из таблицы Appointments удалены...";
    }

    @Override
    public List<Appointment> countByNameDoc(Long id_d) {

        List<Appointment> listApp = template.query(FINDALL, appointmentRowMapper);

        return listApp.stream().filter(x -> x.getId_d().equals(id_d)).toList();

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
