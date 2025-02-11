package ru.innopolis.repositories;


import ru.innopolis.entities.StudentEntity;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void create(StudentEntity student);
    void update(StudentEntity student);
    Optional<StudentEntity> findByName(String fio);
    String delete(Long id);
}
