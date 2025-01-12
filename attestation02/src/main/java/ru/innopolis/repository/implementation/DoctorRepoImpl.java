package ru.innopolis.repository.implementation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import ru.innopolis.JDBCTemplateDriver;
import ru.innopolis.exceptions.ErrorWritingDbById;
import ru.innopolis.exceptions.NoRecordRowDB;
import ru.innopolis.model.Doctor;
import ru.innopolis.repository.DoctorRepository;
import java.util.List;
import java.util.Optional;

public class DoctorRepoImpl implements DoctorRepository {

    JdbcTemplate template = JDBCTemplateDriver.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateDriver.jdbcTemplate());

    private static final String CREATE = "INSERT INTO doctors (id, id_pos, fio_d, tel_d) VALUES (?, ?, ?, ?)";

    private static final String FINDBYID = "SELECT * FROM doctors WHERE id = ?";

    private static final String FINDALL = "SELECT * FROM doctors";

    private static final String UPDATE = "UPDATE doctors SET tel_d = ? WHERE fio_d = ?";

    private static final String DELETEBYID = "DELETE FROM doctors WHERE id = ?";

    private static final String DELETEALL = "DELETE FROM doctors";

        @Override
    public void create(Long id, Long id_pos, String fio_d, String tel_d) throws ErrorWritingDbById {

            try{

                template.update(CREATE, id, id_pos, fio_d, tel_d);

            }
            catch (Exception e){

                throw new ErrorWritingDbById(" -!- Не удалось создать запись с ID = " + id + " . Возможно запись с таким ID уже существует");

            }

    }

    @Override
    public Optional<Doctor> findById(Long id) {

        return templateClient.sql(FINDBYID)
                .param(id)
                .query(Doctor.class)
                .optional();
    }

    @Override
    public List<Doctor> findAll() {

        return template.query(FINDALL, doctorRowMapper);

    }

    @Override
    public String update(Object id, Object id_pos, Object fio_d, Object tel_d) throws IllegalArgumentException{

        Long rowCount;
        String str;

        Optional<Boolean> id_p = Optional.of(id instanceof Long);
        if(!id_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра id не соответствует заданному"); }

        Optional<Boolean> id_pos_p = Optional.of(id_pos instanceof Long);
        if(!id_pos_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра id_pos не соответствует заданному"); }

        Optional<Boolean> fio_d_p = Optional.of(fio_d instanceof String);
        if(!fio_d_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра fio_d не соответствует заданному"); }

        Optional<Boolean> tel_d_p = Optional.of(tel_d instanceof String);
        if(!tel_d_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра tel_d не соответствует заданному"); }


        rowCount = template.queryForObject("SELECT COUNT(*) FROM doctors WHERE id = ?", Long.class, id);

        if(rowCount != 0L){

            template.update(UPDATE, tel_d, fio_d);
            str = "Обновлена запись с ID = " + id;

        }
        else {

            template.update(CREATE, id, id_pos, fio_d, tel_d);
            str = "Добавлена запись с ID = " + id;

        }

        return str;


    }

    @Override
    public String deleteById(Long id) throws NoRecordRowDB {

        String str;

        List<Doctor> listDoc = template.query(FINDALL, doctorRowMapper);

        Optional<Long> result = Optional.of(listDoc.stream().filter(el -> el.getId().equals(id)).count());

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

        return "Все записи из таблицы Doctors удалены...";

    }

    @Override
    public List<Doctor> listById(Long id_pos) {

        List<Doctor> listDoc = template.query(FINDALL, doctorRowMapper);

        return listDoc.stream().filter(x -> x.getId_pos().equals(id_pos)).toList();

    }

    private static final RowMapper<Doctor> doctorRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        Long id_pos = row.getLong("id_pos");
        String fio_d = row.getString("fio_d");
        String tel_d = row.getString("tel_d");

        return new Doctor(id, id_pos, fio_d, tel_d);

    };

}
