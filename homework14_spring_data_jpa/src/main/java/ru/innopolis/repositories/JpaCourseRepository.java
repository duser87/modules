package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.entity.CourseEntity;

public interface JpaCourseRepository extends JpaRepository<CourseEntity, Long> {
}
