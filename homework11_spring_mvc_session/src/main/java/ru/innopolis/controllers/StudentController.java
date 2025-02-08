package ru.innopolis.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.ListRecordsStudentCourses;
import ru.innopolis.dto.StudentRequest;
import ru.innopolis.dto.StudentResponse;
import ru.innopolis.models.Student;
import ru.innopolis.services.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    StudentService service;

    public StudentController(StudentService studentService){
        service = studentService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodCreateStudent(@Valid @RequestBody Student student, HttpSession session){
        Student std = service.create(student, session);
        return ResponseEntity.ok(std);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodUpdateStudent(@Valid @RequestBody Student student, HttpSession session){
        Student stdResponse = service.findByFio(student.getFio());
        stdResponse.setFio(student.getFio());
        stdResponse.setEmail(student.getEmail());
        service.update(stdResponse, session);
        return ResponseEntity.ok(stdResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> methodDeleteStudent(@PathVariable("id") Long id, HttpSession session){
        String noteResponse = service.delete(id, session);
        return ResponseEntity.ok(noteResponse);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodFindByIdStudent(@PathVariable("id") Long id){
        Student stdResponse = service.findById(id);
        return ResponseEntity.ok(stdResponse);
    }

    @PostMapping(path = "/add_course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodRecordOnCourse(@RequestBody StudentRequest request, HttpSession session){
        var result = service.recordOnCourse(request, session);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/list_courses/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListRecordsStudentCourses> methodGetListStudentCourses(@PathVariable("id") Long id){
        var result = service.getListStudentCourses(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/authorize/{id}")
    public ResponseEntity<StudentResponse> methodAuthorizeStudent(@PathVariable("id") Long id, HttpSession session){
        var result = service.authorizationStudent(id, session);
        return ResponseEntity.ok(result);
    }

}
