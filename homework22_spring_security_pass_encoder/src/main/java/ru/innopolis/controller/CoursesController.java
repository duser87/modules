package ru.innopolis.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.entity.CourseEntity;
import ru.innopolis.service.CoursesService;

@RestController
@RequestMapping("/api/v1/course/")
public class CoursesController {
    @Autowired
    CoursesService serviceCourse;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseEntity> createCourse(@Valid @RequestBody CourseEntity crs){
        CourseEntity result = serviceCourse.create(crs);
        return ResponseEntity.ok(result);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseEntity> updateStudent(@Valid @RequestBody CourseEntity crs){
        CourseEntity result = serviceCourse.update(crs);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        String result = serviceCourse.delete(id);
        return ResponseEntity.ok(result);
    }
}
