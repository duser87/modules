package ru.innopolis.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;;
import ru.innopolis.entity.CourseEntity;
import ru.innopolis.services.CoursesService;

@RestController
@RequestMapping("/api/v1/course/")
public class CoursesController {
    @Autowired
    CoursesService serviceCourse;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseEntity> methodCreateCourse(@Valid @RequestBody CourseEntity crs){
        CourseEntity result = serviceCourse.create(crs);
        return ResponseEntity.ok(result);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseEntity> methodUpdateStudent(@Valid @RequestBody CourseEntity crs){
        CourseEntity result = serviceCourse.update(crs);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> methodDeleteStudent(@PathVariable("id") Long id){
        String result = serviceCourse.delete(id);
        return ResponseEntity.ok(result);
    }

}
