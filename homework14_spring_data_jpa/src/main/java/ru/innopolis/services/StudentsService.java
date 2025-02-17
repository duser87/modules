package ru.innopolis.services;

import org.springframework.stereotype.Service;
import ru.innopolis.entity.StudentEntity;
import ru.innopolis.repositories.JpaRepositoryInterface;

@Service
public class StudentsService {

    private JpaRepositoryInterface jpaRepository;

    public StudentsService(JpaRepositoryInterface jpa){
        jpaRepository = jpa;
    }

    public StudentEntity create(StudentEntity student){
        var r = jpaRepository.save(student);
        return r;
    }
}
