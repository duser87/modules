package ru.innopolis.repositories;


import ru.innopolis.entities.StudentEntity;

import java.util.List;

public interface StudentRepository {
    void create(StudentEntity student);
    void update(StudentEntity student);
    StudentEntity findById(Long id);
    List<StudentEntity> findList();
    void delete(Long id);
}
