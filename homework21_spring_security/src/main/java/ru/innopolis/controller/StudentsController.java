package ru.innopolis.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.ListStudentsCourseResponse;
import ru.innopolis.dto.StudentRequest;
import ru.innopolis.dto.StudentResponse;
import ru.innopolis.entity.AuthenticateUser;
import ru.innopolis.entity.StudentEntity;
import ru.innopolis.service.StudentsService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/student/")
public class StudentsController {
    @Autowired
    StudentsService serviceStudent;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentEntity std){
        log.info(std.toString());
        StudentResponse result = serviceStudent.create(std);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> updateStudent(@Valid @RequestBody StudentEntity std){
        StudentResponse result = serviceStudent.update(std);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        String noteResponse = serviceStudent.delete(id);
        return ResponseEntity.ok(noteResponse);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> findByIdStudent(@PathVariable("id") Long id){
        StudentResponse result = serviceStudent.findById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/add_course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> recordOnCourse(@RequestBody StudentRequest request){
        var result = serviceStudent.recordOnCourse(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/list/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListStudentsCourseResponse> getListStudentsCourse(@PathVariable("id") Long id){
        var lscr = serviceStudent.getListStudentsOnCourse(id);
        return ResponseEntity.ok(lscr);
    }

    @GetMapping(value = "/list_age/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentEntity>> getListStudents(@PathVariable("id") Integer id){
        List<StudentEntity> result = serviceStudent.getListStudentByAge(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/list_students/{age}/{id_course}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentResponse>> getListStudentsByAge(@PathVariable("age") Integer age, @PathVariable("id_course") Long idCourse){
        List<StudentResponse> result = serviceStudent.getListStudentByOverOneCourse(age, idCourse);
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/review", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> createReview(@RequestBody StudentRequest request){
        StudentResponse response = serviceStudent.createReview(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/review/{id_student}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> getStudents(@PathVariable("id_student") Long idStudent){
        StudentResponse response = serviceStudent.getListReviewsStudents(idStudent);
        return ResponseEntity.ok(response);
    }

}
