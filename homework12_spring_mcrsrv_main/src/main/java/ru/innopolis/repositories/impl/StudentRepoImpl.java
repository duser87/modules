package ru.innopolis.repositories.impl;


import org.springframework.stereotype.Repository;
import ru.innopolis.entities.StudentEntity;
import ru.innopolis.repositories.StudentRepository;

import java.util.List;

@Repository
public class StudentRepoImpl implements StudentRepository {
    @Override
    public void create(StudentEntity student) {

    }

    @Override
    public void update(StudentEntity student) {

    }

    @Override
    public StudentEntity findById(Long id) {
        return null;
    }

    @Override
    public List<StudentEntity> findList() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
