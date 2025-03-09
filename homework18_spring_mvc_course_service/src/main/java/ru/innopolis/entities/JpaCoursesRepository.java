package ru.innopolis.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.dto.CourseResponse;
import ru.innopolis.model.CourseEntity;

@Repository
public interface JpaCoursesRepository extends JpaRepository<CourseEntity, Long> {
}
