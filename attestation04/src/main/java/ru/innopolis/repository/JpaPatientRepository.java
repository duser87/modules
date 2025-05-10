package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.PatientEntity;

/**
 * Интерфейс, реализующий стандартные CRUD-операции при работе с сущностью PatientEntity из БД
 */
@Repository
public interface JpaPatientRepository extends JpaRepository<PatientEntity, Long> {
    PatientEntity findByFio(String fio);
}