package ru.innopolis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Course;
import ru.innopolis.models.ListCourses;
import ru.innopolis.models.ResponseListCourse;
import ru.innopolis.models.Student;
import ru.innopolis.repositories.CourseRepository;
import ru.innopolis.repositories.ListCoursesRepository;
import ru.innopolis.repositories.StudentRepository;
import ru.innopolis.services.CRUDServiceInterface;

import java.util.Optional;

@Service
public class StudentServiceImpl implements CRUDServiceInterface<Student, String> {

    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final ListCoursesRepository listCoursesRepository;

    public StudentServiceImpl(StudentRepository student,
                              CourseRepository courserepo,
                              ListCoursesRepository listcoursesrepo){
        studentRepository = student;
        courseRepository = courserepo;
        listCoursesRepository = listcoursesrepo;
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

    public String recordOnCourse(ResponseListCourse listCourse)throws Exception{
        listCoursesRepository.create(listCourse.getId(), listCourse.getId_student(), listCourse.getId_course());
        Course course = courseRepository.findById(listCourse.getId_course()).orElseThrow();
        Student student = studentRepository.findById(listCourse.getId_student()).orElseThrow();
        return "Запись студента: " + student.getFio() + " на курс \"" + course.getName() + "\"" + " произведена успешно!";
    }

}
