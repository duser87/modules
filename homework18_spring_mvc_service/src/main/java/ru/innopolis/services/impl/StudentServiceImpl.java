package ru.innopolis.services.impl;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.innopolis.client.CoursesClient;
import ru.innopolis.dto.courses.CourseResponse;
import ru.innopolis.dto.students.StudentRequest;
import ru.innopolis.dto.students.StudentResponse;
import ru.innopolis.entities.ListCoursesEntity;
import ru.innopolis.entities.ReviewEntity;
import ru.innopolis.entities.StudentEntity;
import ru.innopolis.repositories.JpaListCoursesRepository;
import ru.innopolis.repositories.JpaReviewRepository;
import ru.innopolis.repositories.JpaStudentRepository;
import ru.innopolis.services.StudentServiceInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
@Service
public class StudentServiceImpl implements StudentServiceInterface {

        private final JpaStudentRepository studentRepo;
        private final JpaListCoursesRepository listCourseRepo;
        private final JpaReviewRepository reviewRepo;
        private final CoursesClient coursesClient;

        public StudentServiceImpl(JpaStudentRepository _studentRepo,
                                  JpaListCoursesRepository _listCourseRepo,
                                  JpaReviewRepository _reviewRepo,
                                  CoursesClient _coursesClient){
            studentRepo = _studentRepo;
            listCourseRepo =_listCourseRepo;
            coursesClient = _coursesClient;
            reviewRepo = _reviewRepo;
        }

    public StudentResponse create(StudentEntity student){
        studentRepo.save(student);
        StudentResponse response = new StudentResponse();
        response.setFio(student.getFio());
        response.setEmail(student.getEmail());
        response.setAge(student.getAge());
        response.setMessage(" ---> Студент добавлен!");
        return response;
    }

    public String delete(Long id){
        studentRepo.deleteById(id);
        return "Запись с ID - " + id + " удалена!";
    }

        @Override
        public StudentResponse createRecordOnCourse(StudentRequest request){

            StudentResponse response = new StudentResponse();
            ListCoursesEntity list = new ListCoursesEntity();
            List<ListCoursesEntity> allListCourses;
            StudentEntity student;
            CourseResponse course;

            try {
                student= Optional.of(studentRepo.findById(request.getId_student()))
                        .get()
                        .orElseThrow();
                course = Optional.of(coursesClient.getCourse(request.getId_course()))
                        .orElseThrow();
                allListCourses = Optional.of(listCourseRepo.findListCoursesById(student.getId()))
                        .orElseThrow();

                if(course.getActivity()) {
                    response.setFio(student.getFio());
                    response.setCourses(Stream.of(course.getName())
                            .toArray(String[]::new));

                    list.setId_student(student.getId());
                    list.setId_course(course.getId());
                    list.setActivity(course.getActivity());

                    if(allListCourses.isEmpty()) {
                        list.setId(1L);
                        listCourseRepo.save(list);
                        response.setMessage(" ---> Запись на курс прошла успешно!");
                    }
                    else {
                        boolean result = allListCourses.stream()
                                .allMatch(x -> x.getId_course() != request.getId_course());
                        if(result){
                            listCourseRepo.save(list);
                            response.setMessage(" ---> Запись на курс прошла успешно!");
                        }
                        else {
                            response.setMessage(" ---> Нельзя записаться дважды на один и тот же курс...");
                        }
                    }
                }
                else {
                    response.setMessage(" ---> Нельзя записаться на данный курс пока он не активен");
                }

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            return response;
        }


        @Override
        public StudentResponse deleteRecordOnCourse(StudentRequest request) {
            StudentResponse response = new StudentResponse();
            StudentEntity student;
            CourseResponse course;

            try {
                student= Optional.of(studentRepo.findById(request.getId_student()))
                        .get()
                        .orElseThrow();
                course = Optional.of(coursesClient.getCourse(request.getId_course()))
                        .orElseThrow();

                listCourseRepo.deleteByFioAndCourse(student.getId(), course.getId());

                response.setCourses(Stream.of(course.getName())
                        .toArray(String[]::new));
                response.setFio(student.getFio());
                response.setMessage(" ---> Запись с данного курса удалена.");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
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

                response.setFio(student.getFio());
                response.setCourses(str);
                response.setMessage(" ---> Вы записаны на следующие курсы");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return response;
        }

    public StudentResponse findById(Long id){
        var st = studentRepo.findById(id).orElseThrow();
        var lc = listCourseRepo.findListCoursesById(id);
        var cc = coursesClient.getListCourses();
        String[] listCS = lc.stream().map( x-> cc.stream()
                .filter( y -> y.getId().equals(x.getId_course()))
                .map(CourseResponse::getName)).toArray(String[]::new);

        return StudentResponse.builder()
                .id(st.getId())
                .fio(st.getFio())
                .email(st.getEmail())
                .courses(listCS)
                .age(st.getAge())
                .message(" ---> Данные получены")
                .build();
    }

    public List<StudentEntity> getListStudentByAge(Integer id) {
        return studentRepo.findAll().stream().filter(x -> x.getAge() > id ).toList();
    }

    public List<StudentResponse> getListStudentByOverOneCourse(Integer age, Long id_course){
        var result = studentRepo.getListStudentByOverOneCourse(age, id_course);
        var cc = coursesClient.getListCourses();
        return  result.stream().map( x-> StudentResponse.builder()
                .age(x.getAge())
                .fio(x.getFio())
                .email(x.getEmail())
                .courses(cc.stream()
                        .filter( a-> a.getId()
                                .equals(id_course))
                        .map(CourseResponse::getName)
                        .toArray(String[]::new))
                .id(x.getId()).build()).toList();
    }

    public List<StudentResponse> getStudents(Integer age){
        Specification<StudentEntity> result = getSpecificationAge(age);
        var list = studentRepo.findAll(result);
        return list.stream().map(x -> StudentResponse.builder()
                .id(x.getId())
                .fio(x.getFio())
                .age(x.getAge())
                .email(x.getEmail())
                .courses(null)
                .message("Студент найден").build()).toList();
    }

    private Specification<StudentEntity> getSpecificationAge(@NotNull Integer age){
        return (root, query, criteriaBuilder) -> criteriaBuilder.gt(root.get("age"), age);
    }

    public StudentResponse createReview(StudentRequest request) {
        StudentResponse response  = new StudentResponse();
        try {
            var se = studentRepo.findById(request.getId_student());
            var re = reviewRepo.findAllByIdStudent(request.getId_student());
            var ce = coursesClient.getCourse(request.getId_course());

            var responseSE = StudentResponse.builder()
                    .id(request.getId_student())
                    .fio(se.get().getFio())
                    .email(se.get().getEmail())
                    .age(se.get().getAge())
                    .build();

            if (se.get().getId() != 0 & ce.getId() != 0) {
                ReviewEntity review = new ReviewEntity();
                review.setId_student(request.getId_student());
                review.setId_course(request.getId_course());
                review.setReview(request.getReview());
                reviewRepo.save(review);
                responseSE.setMessage(" ---> Комментарий к курсу добавлен!");
                response.setCourses(new String[]{ce.getName() + " >-< " + request.getReview()});
            } else {
                response.setMessage(" ---> Возможно вы не правильно указали пользователя или название курса...");
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return response;
    }

    public StudentResponse getListReviewsStudents(Long id_student){
        StudentResponse response = new StudentResponse();

        try{
            var se = studentRepo.findById(id_student).orElseThrow();

            response.setId(id_student);
            response.setFio(se.getFio());
            response.setEmail(se.getEmail());
            response.setAge(se.getAge());

            if(se.getId() != 0){
                var allReviews = reviewRepo.findAllByIdStudent(id_student);

//                for(int i=0; i<allReviews.size(); i++){
//                    CourseEntity nameCourse = jpaCourseRepository
//                            .findById(allReviews
//                                    .get(i)
//                                    .getId_course())
//                            .orElseThrow();
//                    arrReviews.put(nameCourse.getName(), allReviews.get(i).getReview() + " -><- " + allReviews.get(i).getDate().toString());
//                }
//                log.info(arrReviews.toString());
//                response.setReview(arrReviews);
//                response.setMessage(" ---> Все отзывы студента " + se.getFio());
            }
        }
        catch(Exception e){
            log.info(e.getMessage());
        }
        return response;
    }

}

