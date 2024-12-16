package ru.innopolis.repository;

import ru.innopolis.entity.Doctor;

import java.util.List;

public interface DoctorRepository {

    public List<Doctor> getAll();

    public void addDoctor(Long id, String position, String tel_doctor, String fio_doctor);

    void updateDoctor(String position, String tel_doctor, String fio_doctor);

    public void deleteDoctor(String fio);

}
