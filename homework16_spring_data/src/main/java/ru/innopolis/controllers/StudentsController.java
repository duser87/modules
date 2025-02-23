package ru.innopolis.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.aop.Log;
import ru.innopolis.aop.LogDebug;
import ru.innopolis.dto.ListStudentsCourseResponse;
import ru.innopolis.dto.StudentRequest;
import ru.innopolis.dto.StudentResponse;
import ru.innopolis.entity.StudentEntity;
import ru.innopolis.services.StudentsService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/student/")
public class StudentsController {
    @Autowired
    StudentsService serviceStudent;

    @Log
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodCreateStudent(@Valid @RequestBody StudentEntity std){
        StudentResponse result = serviceStudent.create(std);
        return ResponseEntity.ok(result);
    }

    @Log
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodUpdateStudent(@Valid @RequestBody StudentEntity std){
        StudentResponse result = serviceStudent.update(std);
        return ResponseEntity.ok(result);
    }

    @Log
    @DeleteMapping("/{id}")
    public ResponseEntity<String> methodDeleteStudent(@PathVariable("id") Long id){
        String noteResponse = serviceStudent.delete(id);
        return ResponseEntity.ok(noteResponse);
    }

    @Log
    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodFindByIdStudent(@PathVariable("id") Long id){
        StudentResponse result = serviceStudent.findById(id);
        return ResponseEntity.ok(result);
    }

    @LogDebug
    @Log
    @PostMapping(path = "/add_course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodRecordOnCourse(@RequestBody StudentRequest request){
        var result = serviceStudent.recordOnCourse(request);
        return ResponseEntity.ok(result);
    }

    @LogDebug
    @Log
    @GetMapping(value = "/list/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListStudentsCourseResponse> methodGetListStudentsCourse(@PathVariable("id") Long id){
        var result = serviceStudent.getListStudentsOnCourse(id);
        return ResponseEntity.ok(result);
    }

    @LogDebug
    @GetMapping(value = "/list_age/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentEntity>> methodGetListStudentsByAge(@PathVariable("id") Integer id){
        List<StudentEntity> result = serviceStudent.getListStudentByAge(id);
        return ResponseEntity.ok(result);
    }

    @LogDebug
    @GetMapping(value = "/list_students/{age}/{id_course}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentResponse>> methodGetListStudentsByAge(@PathVariable("age") Integer age, @PathVariable("id_course") Long id_course){
        List<StudentResponse> result = serviceStudent.getListStudentByOverOneCourse(age, id_course);
        return ResponseEntity.ok(result);
    }

    @LogDebug
    @GetMapping(value = "/age_students/{age_students}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentResponse>> methodGetStudents(@PathVariable("age_students") Integer age_students){
        List<StudentResponse> result = serviceStudent.getStudents(age_students);
        return ResponseEntity.ok(result);
    }
}
