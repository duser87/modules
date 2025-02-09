package ru.innopolis.repositories;

import ru.innopolis.entities.ListCoursesEntity;

import java.util.List;

public interface ListCourseRepository {
    void create(ListCoursesEntity entity);
    void update(ListCoursesEntity entity);
    ListCoursesEntity findListCoursesById(Long id);
    List<ListCoursesEntity> findListsCourses();
    void delete(Long id);
}
