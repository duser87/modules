package org.attestation_final.repository;

import org.attestation_final.model.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findByFioAndTel(String fio, String tel);
}
