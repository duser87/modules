package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.dto.CourseResponse;
import ru.innopolis.repositories.CourseRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseRepository repository;
    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourse(@PathVariable Long id){
        var result = repository.getCourse(id).orElseThrow();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseResponse>> getListCourses(){
        var result = repository.getListCourses();
        return ResponseEntity.ok(result);
    }

}
