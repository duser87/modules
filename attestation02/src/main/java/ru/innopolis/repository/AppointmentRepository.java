package ru.innopolis.repository;

import ru.innopolis.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {

    public Boolean create(Long id, String fio_d, String fio_p, String t, String desc);

    public Optional<Appointment> findById(Long id);

    public List<Appointment> findAll();

    public String update(Long id, String fio_d, String fio_p, String time, String desc);

    public void deleteById(Long id);

    public String deleteAll();

    public Long countById(Long id);

}
