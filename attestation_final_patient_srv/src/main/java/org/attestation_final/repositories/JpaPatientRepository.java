package org.attestation_final.repositories;

import org.attestation_final.model.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPatientRepository extends JpaRepository<PatientEntity, Long> {

    PatientEntity findByFioAndTel(String fio, String tel);

}