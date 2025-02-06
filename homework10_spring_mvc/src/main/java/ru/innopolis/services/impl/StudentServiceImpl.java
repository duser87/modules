package ru.innopolis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.ListRecordsStudentCourses;
import ru.innopolis.dto.RecordStudentRequest;
import ru.innopolis.dto.RecordStudentResponse;
import ru.innopolis.models.Course;
import ru.innopolis.models.ListCourses;
import ru.innopolis.models.Student;
import ru.innopolis.repositories.CourseRepository;
import ru.innopolis.repositories.ListCoursesRepository;
import ru.innopolis.repositories.StudentRepository;
import ru.innopolis.services.CRUDServiceInterface;

import java.util.List;

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


    public RecordStudentResponse recordOnCourse(RecordStudentRequest request) {
        List<ListCourses> result = listCoursesRepository.findListCourses(request.getId_student());
        listCoursesRepository.create(request.getId(), request.getId_student(), request.getId_course());
        Student student = studentRepository.findById(request.getId_student()).orElseThrow();
        Course course = courseRepository.findById(request.getId_course()).orElseThrow();
        RecordStudentResponse response = new RecordStudentResponse();
        response.setFio(student.getFio());
        response.setCourse(course.getName());
        response.setMessage("Запись прошла успешно!");
        return response;
    }

    public ListRecordsStudentCourses getListStudentCourses(Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        List<ListCourses> listCourses = listCoursesRepository.findListCourses(id);
        ListRecordsStudentCourses studentCourses = new ListRecordsStudentCourses();
        studentCourses.setFio(student.getFio());
        String[] list = new String[listCourses.size()];
        for(int i=0; i<listCourses.size(); i++){
            var nameCourse = courseRepository.findById(listCourses.get(i).getId_course());
            list[i] = nameCourse.get().getName();
        }
        studentCourses.setListCourses(list);
        return studentCourses;
    }


}
