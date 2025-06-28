package org.attestation_final.repositories;

import org.attestation_final.model.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс, определяющий стандартные CRUD-операции при работе с сущностью AppointmentEntity из БД
 * findByIdEmplAndIdPat - метода, позволяющий получить запись из БД по двум параметрам: id-работника и id-пациента
 */
@Repository
public interface JpaAppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
    @Query(value = "SELECT a FROM AppointmentEntity a WHERE a.idEmpl=:idEmpl AND a.idPat=:idPat")
    public AppointmentEntity findByIdEmplAndIdPat(@Param("idEmpl") Long idEmpl, @Param("idPat") Long idPat);
}