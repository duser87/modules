package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.Entity.PatientEntity;

@Repository
public interface JpaPatientRepository extends JpaRepository<PatientEntity, Long> {

    PatientEntity findByFioAndTel(String fio, String tel);

}
