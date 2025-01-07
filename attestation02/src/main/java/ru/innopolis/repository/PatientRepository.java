package ru.innopolis.repository;

import ru.innopolis.model.Doctor;
import ru.innopolis.model.Patient;

import java.util.List;

public interface PatientRepository {

    public String create();

    public Patient findById(Long id);

    public List<Patient> findAll();

    public String update(Long id, String fio, String tel, String address);

    public String deleteById(Long id);

    public String deleteAll();

    public Long countById(Long id);

}
