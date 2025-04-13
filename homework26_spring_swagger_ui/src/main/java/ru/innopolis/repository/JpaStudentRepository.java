package ru.innopolis.repository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.Student;

/**
 * Интерфейс, реализующий стандартные CRUD-операции при работе с сущностью Student из БД.
 * Наследуется от JpaRepository.
 * Имплементированные методы возвращают объекты типа Student
 */
@Repository
public interface JpaStudentRepository extends JpaRepository<Student, Long>{
    Student findByFio(@NotNull @Size(min = 2, max = 100) String fio);
}
