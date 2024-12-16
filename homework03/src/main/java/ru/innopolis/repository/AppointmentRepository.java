package ru.innopolis.repository;

import ru.innopolis.entity.Appointment;

import java.util.List;

public interface AppointmentRepository {

    public List<Appointment> getAll();

    public void updateAppointment(String time, String desc, String fio_client);

    public void addAppoint(Long id, String fio_doctor, String fio_client, String time, String desc);

    public void deleteAppoint(String fio);

}

