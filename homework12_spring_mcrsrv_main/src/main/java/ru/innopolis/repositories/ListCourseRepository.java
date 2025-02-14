package ru.innopolis.repositories;

import ru.innopolis.entities.ListCoursesEntity;

import java.util.List;

public interface ListCourseRepository {
    void create(ListCoursesEntity entity);
    List<ListCoursesEntity> findListCoursesById(Long id);
    String delete(Long id_student, Long id_course);
}
