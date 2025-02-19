package ru.innopolis.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.EarthquakeEntity;

import java.util.List;

@Qualifier("default")
@Repository
public interface EarthquakeRepository extends JpaRepository<EarthquakeEntity, Long> {

}
