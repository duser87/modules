package ru.innopolis.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.students.StudentRequest;
import ru.innopolis.dto.students.StudentResponse;
import ru.innopolis.services.impl.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(path = "/course/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> createRecordOnCourse(@Valid @RequestBody StudentRequest request){
        StudentResponse result = studentService.createRecord(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/course/del",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> deleteRecordWithCourse(@Valid @RequestBody StudentRequest request){
        StudentResponse result = studentService.deleteRecord(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/course/all/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> getListCourseAllCoursesStudent(@PathVariable("id") Long id){
        StudentResponse result = studentService.getListRecordStudent(id);
        return ResponseEntity.ok(result);
    }

}
