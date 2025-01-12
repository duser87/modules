package ru.innopolis.repository.implementation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import ru.innopolis.JDBCTemplateDriver;
import ru.innopolis.exceptions.ErrorWritingDbById;
import ru.innopolis.exceptions.NoRecordRowDB;
import ru.innopolis.model.Patient;
import ru.innopolis.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

public class PatientRepoImpl implements PatientRepository {

    JdbcTemplate template = JDBCTemplateDriver.jdbcTemplate();
    JdbcClient templateClient = JdbcClient.create(JDBCTemplateDriver.jdbcTemplate());

    private static final String CREATE = "INSERT INTO patients (id, fio, tel, address) VALUES (?, ?, ?, ?)";

    private static final String FINDBYID = "SELECT * FROM patients WHERE id = ?";

    private static final String FINDALL = "SELECT * FROM patients";

    private static final String UPDATE = "UPDATE patients SET tel = ? , address = ? WHERE fio = ?";

    private static final String DELETEBYID = "DELETE FROM patients WHERE id = ?";

    private static final String DELETEALL = "DELETE FROM patients";

    @Override
    public void create(Long id, String fio, String tel, String address) throws ErrorWritingDbById {

        try{

            template.update(CREATE, id, fio, tel, address);

        }
        catch (Exception e){

            throw new ErrorWritingDbById(" -!- Не удалось создать запись с ID = " + id + " . Возможно запись с таким ID уже существует");

        }

    }

    @Override
    public Optional<Patient> findById(Long id) {

        return templateClient.sql(FINDBYID)
                .param(id)
                .query(Patient.class)
                .optional();

    }

    @Override
    public List<Patient> findAll() {

        return template.query(FINDALL, patientRowMapper);

    }

    @Override
    public String update(Object id, Object fio, Object tel, Object address) {

        Long rowCount;
        String str;

        Optional<Boolean> id_p = Optional.of(id instanceof Long);
        if(!id_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра id не соответствует заданному"); }

        Optional<Boolean> fio_p = Optional.of(fio instanceof String);
        if(!fio_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра fio не соответствует заданному"); }

        Optional<Boolean> tel_p = Optional.of(tel instanceof String);
        if(!tel_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра tel не соответствует заданному"); }

        Optional<Boolean> address_p = Optional.of(address instanceof String);
        if(!address_p.get()) { throw  new IllegalArgumentException(" -!- Тип передаваемого параметра address не соответствует заданному"); }


        rowCount = template.queryForObject("SELECT COUNT(*) FROM patients WHERE id = ?", Long.class, id);

        if(rowCount != 0L){

            template.update(UPDATE, tel, address, fio);
            str = "Обновлена запись с ID = " + id;

        }
        else {

            template.update(CREATE, id, fio, tel, address);
            str = "Добавлена запись с ID = " + id;

        }

        return str;

    }

    @Override
    public String deleteById(Long id) throws NoRecordRowDB {

        String str;

        List<Patient> listPat = template.query(FINDALL, patientRowMapper);

        Optional<Long> result = Optional.of(listPat.stream().filter(el -> el.getId().equals(id)).count());

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

        return "Все записи из таблицы Patients удалены...";

    }

    @Override
    public List<Patient> patientByAddress(String address) {

        List<Patient> listDoc = template.query(FINDALL, patientRowMapper);

        return listDoc.stream().filter(x -> x.getAddress().equals(address)).toList();

    }

    private static final RowMapper<Patient> patientRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        String fio = row.getString("fio");
        String tel = row.getString("tel");
        String address = row.getString("address");

        return new Patient(id, fio, tel, address);

    };

}
