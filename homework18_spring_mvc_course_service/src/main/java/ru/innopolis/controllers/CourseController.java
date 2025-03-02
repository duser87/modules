package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.CourseRequest;
import ru.innopolis.dto.CourseResponse;
import ru.innopolis.entities.JpaCoursesRepository;
import ru.innopolis.model.CourseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private JpaCoursesRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<CourseEntity> getCourse(@PathVariable Long id){
        var result = repository.findById(id).orElseThrow();
        CourseEntity course = CourseEntity.builder()
                .id(result.getId())
                .name(result.getName())
                .activity(result.getActivity())
                .build();
        return ResponseEntity.ok(course);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseEntity>> getListCourses(){
        var result = repository.findAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseEntity> create(CourseRequest request){
        CourseEntity course = CourseEntity.builder()
                        .name(request.getName())
                                .activity(request.getActivity())
                                        .build();
        var result = repository.save(course);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.ok("Запись с ID-" + id + " была удалена...");
    }

}