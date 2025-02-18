package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.StudentEntity;

import java.util.List;

@Repository
public interface JpaStudentRepository extends JpaRepository<StudentEntity, Long>  {
    List<StudentEntity> getListStudentByAge(Integer id);
}
