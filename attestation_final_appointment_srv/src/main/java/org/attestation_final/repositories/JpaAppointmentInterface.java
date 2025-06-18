package org.attestation_final.repositories;

import org.attestation_final.model.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAppointmentInterface extends JpaRepository<AppointmentEntity, Long> {
}
