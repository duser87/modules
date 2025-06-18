package org.attestation_final.repositories;

import org.attestation_final.model.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {

    PostEntity findByIdPosAndIdEmpl(Long idPos, Long idEmpl);

}