package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.CourseEntity;

@Repository
public interface JpaCourseRepository extends JpaRepository<CourseEntity, Long> {
}