package ru.innopolis.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.entity.Student;
import ru.innopolis.service.StudentService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/student/")
public class StudentController {

    private final StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodCreateStudent(@Valid @RequestBody Student std){
        var result = studentService.create(std);
        return ResponseEntity.ok(result);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodUpdateStudent(@Valid @RequestBody Student std){
        var result = studentService.update(std);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> methodFindByIdStudent(@PathVariable("id") Long id){
        var result = studentService.findById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> methodDeleteStudent(@PathVariable("id") Long id){
        String noteResponse = studentService.delete(id);
        return ResponseEntity.ok(noteResponse);
    }
}
