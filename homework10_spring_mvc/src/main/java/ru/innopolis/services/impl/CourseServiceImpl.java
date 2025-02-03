package ru.innopolis.services.impl;

import org.springframework.stereotype.Service;
import ru.innopolis.models.Course;
import ru.innopolis.repositories.CourseRepository;
import ru.innopolis.services.CRUDServiceInterface;

@Service
public class CourseServiceImpl implements CRUDServiceInterface<Course, String> {

    CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository course){
        courseRepository = course;
    }

    @Override
    public Course create(Course course) throws Exception {
        return courseRepository.create(course.getId(), course.getTitle()).orElseThrow();
    }

    @Override
    public Course update(Course course) throws Exception {
        return courseRepository.update(course.getId(), course.getTitle()).orElseThrow();
    }

    @Override
    public String delete(Long id) {
        return courseRepository.delete(id);
    }

    @Override
    public Course findById(Long id) throws Exception {
        return courseRepository.findById(id).orElseThrow();
    }
}
