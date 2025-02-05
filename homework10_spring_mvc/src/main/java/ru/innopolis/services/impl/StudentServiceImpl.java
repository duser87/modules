package ru.innopolis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Course;
import ru.innopolis.dto.ListCourseResponse;
import ru.innopolis.models.Student;
import ru.innopolis.repositories.CourseRepository;
import ru.innopolis.repositories.ListCoursesRepository;
import ru.innopolis.repositories.StudentRepository;
import ru.innopolis.services.CRUDServiceInterface;

@Service
public class StudentServiceImpl implements CRUDServiceInterface<Student, String> {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ListCoursesRepository listCoursesRepository;

    @Override
    public Student create(Student student){
        studentRepository.create(student.getId(), student.getFio(), student.getEmail());
        var result = studentRepository.findById(student.getId());
        return result.orElseThrow();
    }

    @Override
    public Student update(Student student){
        studentRepository.update(student.getId(), student.getFio(), student.getEmail());
        var result = studentRepository.findById(student.getId());
        return result.orElseThrow();
    }

    @Override
    public String delete(Long id){
        return studentRepository.delete(id);
    }

    @Override
    public Student findById(Long id){
        return studentRepository.findById(id).orElseThrow();
    }


    public String recordOnCourse(ListCourseResponse listCourse){
        listCoursesRepository.create(listCourse.getId(), listCourse.getId_student(), listCourse.getId_course());
        Course course = courseRepository.findById(listCourse.getId_course()).orElseThrow();
        Student student = studentRepository.findById(listCourse.getId_student()).orElseThrow();
        return "Запись студента: \"" + student.getFio() + "\" на курс \"" + course.getName() + "\"" + " произведена успешно!";
    }

}
