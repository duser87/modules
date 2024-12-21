package ru.innopolis.repository;

import ru.innopolis.model.Doctor;

import java.util.List;

public interface DoctorRepository {

    public List<Doctor> allFind();

    public void addDoc(Long id, String pos, String fio_d, String tel_d);

    public void update(String fio_d, String tel_d);

    public void delete(String fio_d);

}