package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.ListCourseResponse;
import ru.innopolis.models.Student;
import ru.innopolis.services.impl.StudentServiceImpl;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    StudentServiceImpl service;

    public StudentController(StudentServiceImpl studentService){
        service = studentService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodCreateStudent(@RequestBody Student student){
        Student std = service.create(student);
        return ResponseEntity.ok(std);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodUpdateStudent(@RequestBody Student student){
        Student stdResponse = service.findById(student.getId());
        stdResponse.setId(student.getId());
        stdResponse.setFio(student.getFio());
        stdResponse.setEmail(student.getEmail());
        service.update(stdResponse);
        return ResponseEntity.ok(stdResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> methodDeleteStudent(@PathVariable("id") Long id){
        String noteResponse = service.delete(id);
        return ResponseEntity.ok(noteResponse);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodFindByIdStudent(@PathVariable("id") Long id){
        Student stdResponse = service.findById(id);
        return ResponseEntity.ok(stdResponse);
    }

    @PostMapping(path = "/add_course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> methodRecordOnCourse(@RequestBody ListCourseResponse responseListCourse){
        String result = service.recordOnCourse(responseListCourse);
        return ResponseEntity.ok(result);
    }

}
