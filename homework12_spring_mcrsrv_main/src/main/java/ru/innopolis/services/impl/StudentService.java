package ru.innopolis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.client.CoursesClient;
import ru.innopolis.dto.courses.CourseResponse;
import ru.innopolis.dto.students.StudentRequest;
import ru.innopolis.dto.students.StudentResponse;
import ru.innopolis.entities.ListCoursesEntity;
import ru.innopolis.entities.StudentEntity;
import ru.innopolis.repositories.ListCourseRepository;
import ru.innopolis.repositories.StudentRepository;
import ru.innopolis.services.StudentServiceInterface;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private ListCourseRepository listCourseRepo;
    @Autowired
    private CoursesClient coursesClient;


    @Override
    public StudentResponse createRecord(StudentRequest request){
        StudentResponse response = new StudentResponse();
        try {
            StudentEntity student= Optional.of(studentRepo.findByName(request.getFio())).get().orElseThrow();
            CourseResponse course = Optional.of(coursesClient.getCourse(request.getId_course())).orElseThrow();
            ListCoursesEntity list = new ListCoursesEntity();

            String[] str = new String[1];
            str[0] = course.getName();
            response.setName(student.getFio());
            response.setCourses(str);

            if(student.getId() != 0L & course.getId() != null){
                list.setId_student(student.getId());
                list.setId_course(course.getId());
                list.setActivity(0L);
                listCourseRepo.create(list);
                response.setMessage(" ---> Запись на курс прошла успешно!");
            }
            else{
                response.setMessage(" ---> Не удалось провести запись на курс...");
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return response;
    }


    @Override
    public StudentResponse deleteRecord(StudentRequest request) {
        StudentResponse response = new StudentResponse();
        try {
            StudentEntity student= Optional.of(studentRepo.findByName(request.getFio())).get().orElseThrow();
            CourseResponse course = Optional.of(coursesClient.getCourse(request.getId_course())).orElseThrow();

            listCourseRepo.delete(student.getId(), course.getId());

            String[] str = new String[1];
            str[0] = course.getName();
            response.setName(student.getFio());
            response.setCourses(str);
            response.setMessage(" ---> Запись с данного курса удалена.");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Override
    public StudentResponse getListRecordStudent(Long id) {
        StudentResponse response = new StudentResponse();
        try {
            StudentEntity student= Optional.of(studentRepo.findById(id)).get().orElseThrow();
            List<CourseResponse> course = Optional.of(coursesClient.getListCourses()).orElseThrow();

            String[] str = new String[course.size()];
            for(int i=0; i<course.size(); i++){
                str[i] = course.get(i).getName();
            }

            response.setName(student.getFio());
            response.setCourses(str);
            response.setMessage(" ---> Вы записаны на следующие курсы");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
