package ru.innopolis.services;

import org.springframework.stereotype.Service;
import ru.innopolis.aop.Log;
import ru.innopolis.aop.LogDebug;
import ru.innopolis.dto.ListCoursesStudentResponse;
import ru.innopolis.dto.ListStudentsCourseResponse;
import ru.innopolis.dto.StudentRequest;
import ru.innopolis.dto.StudentResponse;
import ru.innopolis.models.Course;
import ru.innopolis.models.ListCourses;
import ru.innopolis.models.Student;
import ru.innopolis.repositories.CourseRepository;
import ru.innopolis.repositories.ListCoursesRepository;
import ru.innopolis.repositories.StudentRepository;
import java.util.List;

@Service
public class StudentsService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private ListCoursesRepository listCoursesRepository;

    public StudentsService(StudentRepository student,
                           CourseRepository course,
                           ListCoursesRepository listCourses){
        studentRepository = student;
        courseRepository = course;
        listCoursesRepository = listCourses;
    }

    @Log
    public Student create(Student student){
        studentRepository.create(student.getId(), student.getFio(), student.getEmail());
        var result = studentRepository.findById(student.getId());
        return result.orElseThrow();
    }

    @Log
    public Student update(Student student){
        studentRepository.update(student.getId(), student.getFio(), student.getEmail());
        var result = studentRepository.findById(student.getId());
        return result.orElseThrow();
    }

    @Log
    public String delete(Long id){
        return studentRepository.delete(id);
    }

    @Log
    public Student findById(Long id){
        return studentRepository.findById(id).orElseThrow();
    }


    @Log
    public StudentResponse recordOnCourse(StudentRequest request) {
        StudentResponse response = new StudentResponse();
        try {
            Student student = studentRepository
                    .findById(request.getId_student())
                    .orElseThrow();
            Course course = courseRepository
                    .findById(request.getId_course())
                    .orElseThrow();
            List<ListCourses> result = listCoursesRepository
                    .findListCourses(request.getId_student());
            boolean resultRecord = result.stream()
                    .anyMatch(p -> p.getId_course()
                            .equals(request.getId_course()));

            if (!resultRecord){
                listCoursesRepository.create(request.getId(), request.getId_student(), request.getId_course());
                response.setFio(student.getFio());
                response.setCourse(course.getName());
                response.setMessage("Запись прошла успешно!");
            }
            else {
                response.setFio(student.getFio());
                response.setCourse(course.getName());
                response.setMessage(" ---> Вы уже записаны на данный курс! Выберите другое направление!");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    @Log
    public ListCoursesStudentResponse getListStudentCourses(Long id){
        ListCoursesStudentResponse studentCourses = new ListCoursesStudentResponse();

        try{
            Student student = studentRepository
                    .findById(id)
                    .orElseThrow();
            List<ListCourses> listCourses = listCoursesRepository.findListCourses(id);
            studentCourses.setFio(student.getFio());
            String[] list = new String[listCourses.size()];
            for(int i=0; i<listCourses.size(); i++){
                var nameCourse = courseRepository
                        .findById(listCourses
                                .get(i)
                                .getId_course());
                list[i] = nameCourse.get().getName();
            }
            studentCourses.setListCourses(list);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return studentCourses;
    }

    @Log
    public ListStudentsCourseResponse getListStudentsOnCourse(Long id_course){
        ListStudentsCourseResponse listStudentsCourseResponse = new ListStudentsCourseResponse();
        try {
            List<ListCourses> listCourses =listCoursesRepository.findListStudentsCourse(id_course);
            List<Student> students = listCourses.stream()
                    .map(x ->studentRepository.findById(x.getId_student())
                            .orElseThrow()).toList();
            Course course = courseRepository.findById(id_course).orElseThrow();
            listStudentsCourseResponse.setCourse(course.getName());
            if(!students.isEmpty()){
                String[] arrFio = students.stream()
                        .map(Student::getFio)
                        .toArray(String[]::new);
                listStudentsCourseResponse.setFio(arrFio);
            }
            else {
                listStudentsCourseResponse.setCourse(" - на данный курс никто не записан");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listStudentsCourseResponse;
    }
}
