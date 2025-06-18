package org.attestation_final.repositories;

import org.attestation_final.model.entities.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPositionRepository extends JpaRepository<PositionEntity, Long> {
    PositionEntity findByPosition(String position);
    void deleteByPosition(String position);
}
