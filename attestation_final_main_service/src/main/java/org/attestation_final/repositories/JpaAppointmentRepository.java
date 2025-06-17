package org.attestation_final.repositories;

import org.attestation_final.models.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    @Query(value = "SELECT a FROM AppointmentEntity a WHERE a.idEmpl=:idEmpl AND a.idPat=:idPat")
    public AppointmentEntity findByIdEmplAndIdPat(@Param("idEmpl") Long idEmpl, @Param("idPat") Long idPat);
}
