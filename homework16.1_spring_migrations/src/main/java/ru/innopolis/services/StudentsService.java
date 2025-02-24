package ru.innopolis.services;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.ListStudentsCourseResponse;
import ru.innopolis.dto.StudentRequest;
import ru.innopolis.dto.StudentResponse;
import ru.innopolis.entity.CourseEntity;
import ru.innopolis.entity.ListCoursesEntity;
import ru.innopolis.entity.ReviewEntity;
import ru.innopolis.entity.StudentEntity;
import ru.innopolis.repositories.JpaCourseRepository;
import ru.innopolis.repositories.JpaListCoursesRepository;
import ru.innopolis.repositories.JpaReviewRepository;
import ru.innopolis.repositories.JpaStudentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StudentsService {

    private final JpaStudentRepository jpaStudentRepository;
    private final JpaCourseRepository jpaCourseRepository;
    private final JpaListCoursesRepository jpaListCoursesRepository;
    private final JpaReviewRepository jpaReviewRepository;

    public StudentsService(JpaStudentRepository jpaStudent,
                           JpaCourseRepository jpaCourse,
                           JpaListCoursesRepository jpaList,
                           JpaReviewRepository jpaReview){
        jpaStudentRepository= jpaStudent;
        jpaCourseRepository = jpaCourse;
        jpaListCoursesRepository = jpaList;
        jpaReviewRepository = jpaReview;
    }

    public StudentResponse create(StudentEntity student){
        jpaStudentRepository.save(student);
        StudentResponse response = new StudentResponse();
        response.setFio(student.getFio());
        response.setEmail(student.getEmail());
        response.setAge(student.getAge());
        response.setMessage(" ---> Студент добавлен!");
        return response;
    }

    public String delete(Long id){
        jpaStudentRepository.deleteById(id);
        return "Запись с ID - " + id + " удалена!";
    }

    public StudentResponse update(StudentEntity student){
        StudentEntity studentOld = jpaStudentRepository.findById(student.getId()).orElseThrow();
        studentOld.setFio(student.getFio());
        studentOld.setEmail(student.getEmail());
        studentOld.setAge(student.getAge());
        var result = jpaStudentRepository.save(studentOld);
        StudentResponse response = new StudentResponse();
        response.setFio(result.getFio());
        response.setEmail(result.getEmail());
        response.setAge(result.getAge());
        response.setMessage(" ---> Данные студента обновлены успешно!");
        return response;
    }

    public StudentResponse findById(Long id){
        var result = jpaStudentRepository.findById(id).orElseThrow();
        StudentResponse response = new StudentResponse();
        response.setFio(result.getFio());
        response.setEmail(result.getEmail());
        response.setAge(result.getAge());
        response.setMessage(" ---> Данные студента получены!");
        return response;
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
            List<ListCoursesEntity> listCourse = jpaListCoursesRepository.findAll();

            List<ListCoursesEntity> resultFilter;
            boolean resultRecord = true;

            response.setId(student.getId());
            response.setFio(student.getFio());
            response.setEmail(student.getEmail());
            response.setAge(student.getAge());
            response.setCourse(course.getName());

            if(listCourse.size() != 0){
                resultFilter = listCourse.stream()
                        .filter( x-> x.getId_student()
                                .equals(request.getId_student()))
                        .toList();
                resultRecord = resultFilter.stream()
                        .anyMatch(p -> p.getId_course()
                                .equals(request.getId_course()));

                if(!resultRecord){
                    if(!course.getActivity()){
                        response.setMessage("Невозможно записаться на курс. Курс не активен!");
                    }
                    else{
                        ListCoursesEntity newList = new ListCoursesEntity();
                        newList.setId_student(student.getId());
                        newList.setId_course(course.getId());
                        newList.setActivity(course.getActivity());
                        jpaListCoursesRepository.save(newList);
                        response.setMessage("Запись прошла успешно!");
                    }
                }
                else{
                    response.setMessage("Вы уже записаны на данный курс. Выберите другое направление");
                }

            }
            else{
                ListCoursesEntity newList = new ListCoursesEntity();
                newList.setId_student(student.getId());
                newList.setId_course(course.getId());
                newList.setActivity(course.getActivity());
                jpaListCoursesRepository.save(newList);
                response.setMessage("Запись прошла успешно!");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            response.setMessage(">>> ОШИБКА: " + e.getMessage());
        }
        return response;
    }

    public ListStudentsCourseResponse getListStudentsOnCourse(Long id_course){
        ListStudentsCourseResponse listStudentsCourseResponse = new ListStudentsCourseResponse();
        try {
            List<ListCoursesEntity> result = jpaListCoursesRepository.findAll();
            List<ListCoursesEntity> resultFilter = result.stream()
                    .filter(x-> x.getId_course().equals(id_course))
                    .toList();
            List<StudentEntity> students = resultFilter.stream()
                    .map(x->jpaStudentRepository.findById(x.getId_student())
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

    public List<StudentEntity> getListStudentByAge(Integer id) {
        return jpaStudentRepository.findAll().stream().filter(x -> x.getAge() > id ).toList();
    }

    public List<StudentResponse> getListStudentByOverOneCourse(Integer age, Long id_course){
        var result = jpaStudentRepository.getListStudentByOverOneCourse(age, id_course);
        return  result.stream().map( x-> StudentResponse.builder()
                .age(x.getAge())
                .fio(x.getFio())
                .email(x.getEmail())
                .course(jpaCourseRepository.findById(id_course).get().getName())
                .id(x.getId()).build()).toList();
    }


    public List<StudentResponse> getStudents(Integer age){
        Specification<StudentEntity> result = getSpecificationAge(age);
        var list = jpaStudentRepository.findAll(result);
        return list.stream().map(x -> StudentResponse.builder()
                .id(x.getId())
                .fio(x.getFio())
                .age(x.getAge())
                .email(x.getEmail())
                .course(null)
                .message("Студент найден").build()).toList();
    }

    private Specification<StudentEntity> getSpecificationAge(@NotNull Integer age){
        return (root, query, criteriaBuilder) -> criteriaBuilder.gt(root.get("age"), age);
    }

    // Methods of working with reviews

    public StudentResponse createReview(StudentRequest request) {
        StudentResponse response  = new StudentResponse();
        try {
            var se = jpaStudentRepository.findById(request.getId_student());
            var ce = jpaCourseRepository.findById(request.getId_course());

            response.setId(request.getId_student());
            response.setFio(se.get().getFio());
            response.setEmail(se.get().getEmail());
            response.setAge(se.get().getAge());
            response.setCourse(ce.get().getName());

            if (se.get().getId() != 0 & ce.get().getId() != 0) {
                ReviewEntity review = new ReviewEntity();
                review.setId_student(request.getId_student());
                review.setId_course(request.getId_course());
                review.setReview(request.getReview());
                jpaReviewRepository.save(review);
                response.setMessage(" ---> Комментарий к курсу добавлен!");
                HashMap<String, String> rev = new HashMap<>();
                rev.put(ce.get().getName(), request.getReview());
                response.setReview(rev);
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
        HashMap<String, String> arrReviews = new HashMap<>();
        try{
            var se = jpaStudentRepository.findById(id_student).orElseThrow();

            response.setId(id_student);
            response.setFio(se.getFio());
            response.setEmail(se.getEmail());
            response.setAge(se.getAge());

            if(se.getId() != 0){
                var allReviews = jpaReviewRepository.findAllByIdStudent(id_student);
                for(int i=0; i<allReviews.size(); i++){
                    CourseEntity nameCourse = jpaCourseRepository
                            .findById(allReviews
                                    .get(i)
                                    .getId_course())
                            .orElseThrow();
                    arrReviews.put(nameCourse.getName(), allReviews.get(i).getReview() + " -><- " + allReviews.get(i).getDate().toString());
                }
                log.info(arrReviews.toString());
               response.setReview(arrReviews);
               response.setMessage(" ---> Все отзывы студента " + se.getFio());
            }
        }
        catch(Exception e){
            log.info(e.getMessage());
        }
        return response;
    }

}