package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.Entity.AppointmentEntity;

import java.util.List;

@Repository
public interface JpaAppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    @Query(value = "SELECT a FROM AppointmentEntity a WHERE a.idEmpl=:idEmpl AND a.idPat=:idPat")
    public AppointmentEntity findByIdEmplAndIdPat(@Param("idEmpl") Long idEmpl, @Param("idPat") Long idPat);
}
