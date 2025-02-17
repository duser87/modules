package ru.innopolis.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.aop.LogDebug;
import ru.innopolis.dto.ListStudentsCourseResponse;
import ru.innopolis.dto.StudentRequest;
import ru.innopolis.dto.StudentResponse;
import ru.innopolis.entity.StudentEntity;
import ru.innopolis.services.StudentsService;

@Slf4j
@RestController
@RequestMapping("/api/v1/student/")
public class StudentsController {
    @Autowired
    StudentsService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentEntity> methodCreateStudent(@Valid @RequestBody StudentEntity student){
        log.info("START");
        StudentEntity std = service.create(student);
        log.info("STOP");
        return ResponseEntity.ok(std);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentEntity> methodUpdateStudent(@Valid @RequestBody StudentEntity student){
        StudentEntity stdResponse = service.findById(student.getId());
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
    public ResponseEntity<StudentEntity> methodFindByIdStudent(@PathVariable("id") Long id){
        StudentEntity stdResponse = service.findById(id);
        return ResponseEntity.ok(stdResponse);
    }

    @LogDebug
    @PostMapping(path = "/add_course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> methodRecordOnCourse(@RequestBody StudentRequest request){
        var result = service.recordOnCourse(request);
        return ResponseEntity.ok(result);
    }

    @LogDebug
    @GetMapping(value = "/list/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListStudentsCourseResponse> methodGetListStudentsCourse(@PathVariable("id") Long id){
        var result = service.getListStudentsOnCourse(id);
        return ResponseEntity.ok(result);
    }
}
