package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.AppointmentsEntity;

/**
 * Интерфейс, реализующий стандартные CRUD-операции при работе с сущностью AppointmentsEntity из БД
 */
@Repository
public interface JpaAppointmentRepository extends JpaRepository<AppointmentsEntity, Long> {
}