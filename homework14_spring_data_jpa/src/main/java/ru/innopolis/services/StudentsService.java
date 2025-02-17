package ru.innopolis.services;

import org.springframework.stereotype.Service;
import ru.innopolis.dto.ListStudentsCourseResponse;
import ru.innopolis.dto.StudentRequest;
import ru.innopolis.dto.StudentResponse;
import ru.innopolis.entity.CourseEntity;
import ru.innopolis.entity.ListCoursesEntity;
import ru.innopolis.entity.StudentEntity;
import ru.innopolis.repositories.JpaCourseRepository;
import ru.innopolis.repositories.JpaListCoursesRepository;
import ru.innopolis.repositories.JpaStudentRepository;

import java.util.List;

@Service
public class StudentsService {

    private JpaStudentRepository jpaStudentRepository;
    private JpaCourseRepository jpaCourseRepository;
    private JpaListCoursesRepository jpaListCoursesRepository;

    public StudentsService(JpaStudentRepository jpaStudent,
                           JpaCourseRepository jpaCourse,
                           JpaListCoursesRepository jpaList){
        jpaStudentRepository= jpaStudent;
        jpaCourseRepository = jpaCourse;
        jpaListCoursesRepository = jpaList;
    }

    public StudentEntity create(StudentEntity student){
        return jpaStudentRepository.save(student);
    }

    public String delete(Long id){
        jpaStudentRepository.deleteById(id);
        return "Запись с ID - {id} удалена!";
    }

    public StudentEntity update(StudentEntity student){
        StudentEntity studentOld = jpaStudentRepository.findById(student.getId()).orElseThrow();
        studentOld.setFio(student.getFio());
        studentOld.setEmail(student.getEmail());
        studentOld.setAge(student.getAge());
        return jpaStudentRepository.save(studentOld);
    }

    public StudentEntity findById(Long id){
        return jpaStudentRepository.findById(id).orElseThrow();
    }

    public StudentResponse recordOnCourse(StudentRequest request) {
        StudentResponse response = new StudentResponse();
        try {
            StudentEntity student = jpaStudentRepository
                    .findById(request.getId_student())
                    .orElseThrow();
            CourseEntity course = jpaCourseRepository
                    .findById(request.getId_course())
                    .orElseThrow();
            List<ListCoursesEntity> result = jpaListCoursesRepository.findAll();
            List<ListCoursesEntity> resultFilter = result.stream()
                    .filter( x-> x.getId_student()
                            .equals(request.getId_student()))
                    .toList();
            boolean resultRecord = resultFilter.stream()
                    .anyMatch(p -> p.getId_course()
                            .equals(request.getId_course()));

            if (!resultRecord){
                ListCoursesEntity newList = new ListCoursesEntity();
                newList.setId(request.getId());
                newList.setId_student(student);
                newList.setId_course(course);
                jpaListCoursesRepository.save(newList);
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

    public ListStudentsCourseResponse getListStudentsOnCourse(Long id_course){
        ListStudentsCourseResponse listStudentsCourseResponse = new ListStudentsCourseResponse();
        try {
            //List<ListCoursesEntity> listCourses =listCoursesRepository.findListStudentsCourse(id_course);
            List<ListCoursesEntity> result = jpaListCoursesRepository.findAll();
            List<ListCoursesEntity> resultFilter = result.stream()
                    .filter(x-> x.getId_course().equals(id_course))
                    .toList();
            List<StudentEntity> students = resultFilter.stream()
                    .map(x->jpaStudentRepository.findById(x.getId_student().getId())
                            .orElseThrow()).toList();
            CourseEntity course = jpaCourseRepository.findById(id_course).orElseThrow();
            listStudentsCourseResponse.setCourse(course.getName());
            if(!students.isEmpty()){
                String[] arrFio = students.stream()
                        .map(StudentEntity::getFio)
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
