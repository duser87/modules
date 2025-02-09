package ru.innopolis.repositories.impl;

import org.springframework.stereotype.Repository;
import ru.innopolis.entities.ListCoursesEntity;
import ru.innopolis.repositories.ListCourseRepository;

import java.util.List;

@Repository
public class ListCourseRepoImpl implements ListCourseRepository {

    @Override
    public void create(ListCoursesEntity entity) {

    }

    @Override
    public void update(ListCoursesEntity entity) {

    }

    @Override
    public ListCoursesEntity findListCoursesById(Long id) {
        return null;
    }

    @Override
    public List<ListCoursesEntity> findListsCourses() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
