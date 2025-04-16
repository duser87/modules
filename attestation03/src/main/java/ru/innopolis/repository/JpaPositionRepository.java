package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.PositionEntity;

@Repository
public interface JpaPositionRepository extends JpaRepository<PositionEntity, Long> {
    PositionEntity findByPosition(String position);
}
