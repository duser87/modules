package ru.innopolis.services.impl;

import org.springframework.stereotype.Service;
import ru.innopolis.models.Student;
import ru.innopolis.repositories.CourseRepository;
import ru.innopolis.repositories.StudentRepository;
import ru.innopolis.services.CRUDServiceInterface;

import java.util.List;

@Service
public class StudentServiceImpl implements CRUDServiceInterface<Student, String> {


    StudentRepository studentRepository;
    CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository student,
                              CourseRepository course){
        studentRepository = student;
        courseRepository = course;

    }

    @Override
    public Student create(Student student)throws Exception{
        return studentRepository.create(student.getId(), student.getFio(), student.getEmail()).orElseThrow();
    }

    @Override
    public Student update(Student student)throws Exception {
        studentRepository.update(student.getId(), student.getFio(), student.getEmail()).orElseThrow();
        return null;
    }

    @Override
    public String delete(Long id) {
        return studentRepository.delete(id);
    }

    @Override
    public Student findById(Long id) throws Exception{
        return studentRepository.findById(id).orElseThrow();
    }

    public String recordOnCourse(Student student){
        return "";
    }

}
