package ru.innopolis.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.EarthquakeEntity;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EarthquakeRepository extends JpaRepository<EarthquakeEntity, Long> {
    List<EarthquakeEntity> findByTimeBetween(LocalDateTime timeAfter, LocalDateTime timeBefore);
}
