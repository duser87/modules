package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.Entity.PositionEntity;

@Repository
public interface JpaPositionRepository extends JpaRepository<PositionEntity, Long> {
    PositionEntity findByPosition(String position);

    void deleteByPosition(String position);
}
