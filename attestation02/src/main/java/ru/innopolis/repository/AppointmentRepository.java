package ru.innopolis.repository;

import ru.innopolis.exceptions.ErrorWritingDbById;
import ru.innopolis.exceptions.NoRecordRowDB;
import ru.innopolis.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {

    public void create(Long id, String fio_d, String fio_p, String t, String desc) throws ErrorWritingDbById;

    public Optional<Appointment> findById(Long id);

    public List<Appointment> findAll();

    public String  update (Object id, Object fio_d, Object fio_p, Object time, Object desc) throws IllegalArgumentException;

    public String deleteById(Long id) throws NoRecordRowDB;

    public String deleteAll();

    public List<Appointment> countByNameDoc(Long id_d);

}
