package org.attestation_final.repositories;

import org.attestation_final.model.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс, определяющий стандартные CRUD-операции при работе с сущностью PatientEntity из БД
 * findByFioAndTel - метода, позволяющий получить запись из БД по двум параметрам: fio и tel
 */
@Repository
public interface JpaPatientRepository extends JpaRepository<PatientEntity, Long> {

    PatientEntity findByFioAndTel(String fio, String tel);

}