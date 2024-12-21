package ru.innopolis.repository;

import ru.innopolis.model.Appointment;

import java.util.List;

public interface AppointmentRepository {

    public List<Appointment> allFind();

    public void addApp(Long id, String fio_d, String fio_p, String time, String desc);

    public void update(String fio_p, String time, String desc);

    public void delete(String fio_p);

}