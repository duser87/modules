package ru.innopolis.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.courses.CourseResponse;
import ru.innopolis.dto.students.StudentRequest;
import ru.innopolis.dto.students.StudentResponse;
import ru.innopolis.entities.StudentEntity;
import ru.innopolis.services.impl.StudentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    //Методы, реализующие работу с записью на курс

    @PostMapping(path = "/record/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> createRecordOnCourse(@Valid @RequestBody StudentRequest request){
        StudentResponse result = studentService.createRecordOnCourse(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/record/del",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> deleteRecordWithCourse(@Valid @RequestBody StudentRequest request){
        StudentResponse result = studentService.deleteRecordOnCourse(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/record/all/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> getListCourseStudent(@PathVariable("id") Long id){
        StudentResponse result = studentService.getListRecordStudent(id);
        return ResponseEntity.ok(result);
    }

    // Методы для работы с сущностью "Студент"

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentEntity std){
        StudentResponse result = studentService.create(std);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        String noteResponse = studentService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> findByIdStudent(@PathVariable("id") Long id){
        StudentResponse result = studentService.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/list_age/{age}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentEntity>> getListStudentsByAge(@PathVariable("age") Integer age){
        List<StudentEntity> result = studentService.getListStudentByAge(age);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/list_students/{age}/{id_course}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentResponse>> getListStudentsByAgeAndCourse(@PathVariable("age") Integer age, @PathVariable("id_course") Long idCourse){
        List<StudentResponse> result = studentService.getListStudentByOverOneCourse(age, idCourse);
        return ResponseEntity.ok(result);
    }

//    @GetMapping(value = "/age_students/{age_students}", produces =MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<StudentResponse>> getStudents(@PathVariable("age_students") Integer ageStudents){
//        List<StudentResponse> result = studentService.getStudents(ageStudents);
//        return ResponseEntity.ok(result);
//    }

    @PostMapping(path = "/review", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> createReview(@RequestBody StudentRequest request){
        StudentResponse response = studentService.createReview(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/review/{id_student}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> getListReviewsStudent(@PathVariable("id_student") Long idStudent){
        StudentResponse response = studentService.getListReviewsStudents(idStudent);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/info/")
    public ResponseEntity<CourseResponse> getInfoByCourses(){
        return ResponseEntity.ok().build();
    }

}