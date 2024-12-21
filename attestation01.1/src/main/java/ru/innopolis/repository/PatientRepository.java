package ru.innopolis.repository;

import ru.innopolis.model.Patient;

import java.util.List;

public interface PatientRepository {

    public List<Patient> allFind();

    public void addPat(Long id, String fio, String tel, String address);

    public void update(String fio, String tel, String address);

    public void delete(String fio_d);

}