package ru.innopolis.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(path = "/rec/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodeCreateRecordOnCourse(@Valid @RequestBody StudentRequest request){
        StudentResponse result = studentService.createRecordOnCourse(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/rec/del",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodeDeleteRecordWithCourse(@Valid @RequestBody StudentRequest request){
        StudentResponse result = studentService.deleteRecordOnCourse(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/rec/all/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodGetListCourseStudent(@PathVariable("id") Long id){
        StudentResponse result = studentService.getListRecordStudent(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodCreateStudent(@Valid @RequestBody StudentEntity std){
        StudentResponse result = studentService.create(std);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> methodDeleteStudent(@PathVariable("id") Long id){
        String noteResponse = studentService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodFindByIdStudent(@PathVariable("id") Long id){
        StudentResponse result = studentService.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/list_age/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentEntity>> methodGetListStudentsByAge(@PathVariable("id") Integer id){
        List<StudentEntity> result = studentService.getListStudentByAge(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/list_students/{age}/{id_course}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentResponse>> methodGetListStudentsByAgeAndCourse(@PathVariable("age") Integer age, @PathVariable("id_course") Long id_course){
        List<StudentResponse> result = studentService.getListStudentByOverOneCourse(age, id_course);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/age_students/{age_students}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentResponse>> methodGetStudents(@PathVariable("age_students") Integer age_students){
        List<StudentResponse> result = studentService.getStudents(age_students);
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/review", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodCreateReview(@RequestBody StudentRequest request){
        StudentResponse response = studentService.createReview(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/review/{id_student}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodGetStudents(@PathVariable("id_student") Long id_student){
        StudentResponse response = studentService.getListReviewsStudents(id_student);
        return ResponseEntity.ok(response);
    }

}