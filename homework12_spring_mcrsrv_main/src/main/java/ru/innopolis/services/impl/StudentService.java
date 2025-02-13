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
import java.util.stream.Stream;

@Service
public class StudentService implements StudentServiceInterface {

    private StudentRepository studentRepo;
    private ListCourseRepository listCourseRepo;
    @Autowired
    private CoursesClient coursesClient;

    public StudentService(StudentRepository _studentRepo,
                          ListCourseRepository _listCourseRepo){
        studentRepo = _studentRepo;
        listCourseRepo =_listCourseRepo;
    }


    @Override
    public StudentResponse createRecord(StudentRequest request){
        StudentResponse response = new StudentResponse();
        ListCoursesEntity list = new ListCoursesEntity();
        List<ListCoursesEntity> allListCourses;
        StudentEntity student;
        CourseResponse course;

        try {
            student= Optional.of(studentRepo.findByName(request.getFio()))
                    .get()
                    .orElseThrow();
            course = Optional.of(coursesClient.getCourse(request.getId_course()))
                    .orElseThrow();
            allListCourses = Optional.of(listCourseRepo.findListCoursesById(student.getId()))
                    .orElseThrow();

            if(course.getActivity()) {

                response.setName(student.getFio());
                response.setCourses(Stream.of(course.getName())
                        .toArray(String[]::new));
                boolean result = allListCourses.stream()
                        .allMatch(x -> x.getId_course() != request.getId_course());

                if(result){
                    list.setId_student(student.getId());
                    list.setId_course(course.getId());
                    list.setActivity(course.getActivity());
                    listCourseRepo.create(list);
                    response.setMessage(" ---> Запись на курс прошла успешно!");
                }
                else {
                    response.setMessage(" ---> Нельзя записаться дважды на один и тот же курс...");
                }

            }
            else {
                response.setMessage(" ---> Нельзя записаться на данный курс пока он не активен");
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
        StudentEntity student;
        CourseResponse course;

        try {
            student= Optional.of(studentRepo.findByName(request.getFio()))
                    .get()
                    .orElseThrow();
            course = Optional.of(coursesClient.getCourse(request.getId_course()))
                    .orElseThrow();

            listCourseRepo.delete(student.getId(), course.getId());

            response.setCourses(Stream.of(course.getName())
                    .toArray(String[]::new));
            response.setName(student.getFio());
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
        StudentEntity student;
        List<ListCoursesEntity> list;

        try {
            student= Optional.of(studentRepo.findById(id))
                    .get()
                    .orElseThrow();
            list= Optional.of(listCourseRepo.findListCoursesById(id))
                    .orElseThrow();

            String[] str = new String[list.size()];
            for(int i=0; i<list.size(); i++){
                Long in = list.get(i).getId_course();
                CourseResponse courseResponse = Optional.of(coursesClient.getCourse(in)).orElseThrow();
                str[i] = "< " + courseResponse.getName() + " >" + " - начало обучения на курсе с " + list.get(i).getStart_date();
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
