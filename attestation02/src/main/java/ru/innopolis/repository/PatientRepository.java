package ru.innopolis.repository;

import ru.innopolis.exceptions.ErrorWritingDbById;
import ru.innopolis.exceptions.NoRecordRowDB;
import ru.innopolis.model.Doctor;
import ru.innopolis.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {

    public void create(Long id, String fio, String tel, String address) throws ErrorWritingDbById;

    public Optional<Patient> findById(Long id);

    public List<Patient> findAll();

    public String update(Object id, Object fio, Object tel, Object address) throws IllegalArgumentException;

    public String deleteById(Long id) throws NoRecordRowDB;

    public String deleteAll();

    public List<Patient> patientByAddress(String address);

}
