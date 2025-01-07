package ru.innopolis.repository.implementation;

import ru.innopolis.model.Doctor;
import ru.innopolis.repository.DoctorRepository;

import java.util.List;

public class DoctorRepoImpl implements DoctorRepository {
    @Override
    public String create() {
        return "";
    }

    @Override
    public Doctor findById(Long id) {
        return null;
    }

    @Override
    public List<Doctor> findAll() {
        return List.of();
    }

    @Override
    public String update(Long id, Long id_pos, String fio_d, String tel_d) {
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
