package ru.innopolis.repository;

import ru.innopolis.model.Doctor;

import java.util.List;

public interface DoctorRepository {

    public String create();

    public Doctor findById(Long id);

    public List<Doctor> findAll();

    public String update(Long id, Long id_pos, String fio_d, String tel_d);

    public String deleteById(Long id);

    public String deleteAll();

    public Long countById(Long id);

}
