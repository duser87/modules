package org.attestation_final.repository;

import org.attestation_final.model.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс, определяющий стандартные CRUD-операции при работе с сущностью AppointmentEntity из БД
 * findByFioAndTel - метода, позволяющий получить запись из БД по двум параметрам: фио работника и  тел пациента
 */
@Repository
public interface JpaEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findByFioAndTel(String fio, String tel);
}
