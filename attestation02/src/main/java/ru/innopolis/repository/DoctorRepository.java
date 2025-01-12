package ru.innopolis.repository;

import ru.innopolis.exceptions.ErrorWritingDbById;
import ru.innopolis.exceptions.NoRecordRowDB;
import ru.innopolis.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository {

    public void create(Long id, Long id_pos, String fio_d, String tel_d) throws ErrorWritingDbById;

    public Optional<Doctor> findById(Long id);

    public List<Doctor> findAll();

    public String update(Object id, Object id_pos, Object fio_d, Object tel_d) throws IllegalArgumentException;

    public String deleteById(Long id) throws NoRecordRowDB;

    public String deleteAll();

    public List<Doctor> listById(Long id_pos);

}
