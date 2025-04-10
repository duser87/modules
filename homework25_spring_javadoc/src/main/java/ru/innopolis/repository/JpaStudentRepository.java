package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.Student;

@Repository
public interface JpaStudentRepository extends JpaRepository<Student, Long> {
}
