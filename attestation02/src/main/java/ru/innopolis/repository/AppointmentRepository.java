package ru.innopolis.repository;

import ru.innopolis.model.Appointment;

import java.util.List;

public interface AppointmentRepository {

    public String create();

    public Appointment findById(Long id);

    public List<Appointment> findAll();

    public String update(Long id, String fio_d, String fio_p, String time, String desc);

    public String deleteById(Long id);

    public String deleteAll();

    public Long countById(Long id);

}
