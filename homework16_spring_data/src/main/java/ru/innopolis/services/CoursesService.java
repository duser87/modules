package ru.innopolis.services;

import org.springframework.stereotype.Service;
import ru.innopolis.entity.CourseEntity;
import ru.innopolis.repositories.JpaCourseRepository;

@Service
public class CoursesService {
    private JpaCourseRepository jpaCourseRepository;

    public CoursesService(JpaCourseRepository jpaCourse){
        jpaCourseRepository = jpaCourse;
    }

    public CourseEntity create(CourseEntity course){
        jpaCourseRepository.save(course);
        return jpaCourseRepository.findById(course.getId()).orElseThrow();
    }

    public CourseEntity update(CourseEntity course){
        CourseEntity result = jpaCourseRepository.findById(course.getId()).orElseThrow();
        result.setName(course.getName());
        result.setActivity(course.getActivity());
        jpaCourseRepository.save(result);
        return jpaCourseRepository.findById(course.getId()).orElseThrow();
    }

    public String delete(Long id){
        jpaCourseRepository.deleteById(id);
        return "Запись с ID -" + id + " была удалена...";
    }

    public CourseEntity findById(Long id){
        return jpaCourseRepository.findById(id).orElseThrow();
    }
}
