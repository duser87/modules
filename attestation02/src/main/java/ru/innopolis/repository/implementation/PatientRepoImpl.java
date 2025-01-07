package ru.innopolis.repository.implementation;

import ru.innopolis.model.Patient;
import ru.innopolis.repository.PatientRepository;

import java.util.List;

public class PatientRepoImpl implements PatientRepository {
    @Override
    public String create() {
        return "";
    }

    @Override
    public Patient findById(Long id) {
        return null;
    }

    @Override
    public List<Patient> findAll() {
        return List.of();
    }

    @Override
    public String update(Long id, String fio, String tel, String address) {
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
