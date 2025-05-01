package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.PatientEntity;

@Repository
public interface JpaPatientRepository extends JpaRepository<PatientEntity, Long> {
    PatientEntity findByFio(String fio);
}