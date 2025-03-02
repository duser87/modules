package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.models.InfoEntity;

@Repository
public interface JpaInfoRepository extends JpaRepository<InfoEntity, Long> {
}
