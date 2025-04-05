package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.AppointmentsEntity;
import ru.innopolis.entity.DoctorEntity;

@Repository
public interface JpaDoctorRepository extends JpaRepository<DoctorEntity, Long> {
    DoctorEntity findByFioDoc(String fioDoc);
}
