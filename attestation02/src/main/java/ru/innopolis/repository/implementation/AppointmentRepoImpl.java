package ru.innopolis.repository.implementation;

import ru.innopolis.model.Appointment;
import ru.innopolis.repository.AppointmentRepository;

import java.util.List;

public class AppointmentRepoImpl implements AppointmentRepository {
    @Override
    public String create() {
        return "";
    }

    @Override
    public Appointment findById(Long id) {
        return null;
    }

    @Override
    public List<Appointment> findAll() {
        return List.of();
    }

    @Override
    public String update(Long id, String fio_d, String fio_p, String time, String desc) {
        return "";
    }

    @Override
    public String deleteById(Long id) {
        return "";
    }

    @Override
    public String deleteAll() {
        return "";
    }

    @Override
    public Long countById(Long id) {
        return 0L;
    }
}
