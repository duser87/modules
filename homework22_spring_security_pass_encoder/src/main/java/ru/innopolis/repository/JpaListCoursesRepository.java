package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.ListCoursesEntity;

@Repository
public interface JpaListCoursesRepository extends JpaRepository<ListCoursesEntity, Long> {
}