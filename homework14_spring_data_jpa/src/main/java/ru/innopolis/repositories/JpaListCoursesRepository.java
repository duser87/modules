package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.entity.ListCoursesEntity;

public interface JpaListCoursesRepository extends JpaRepository<ListCoursesEntity, Long> {
}
