package ru.innopolis.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.CourseRequest;
import ru.innopolis.dto.CourseResponse;
import ru.innopolis.entities.JpaCoursesRepository;
import ru.innopolis.model.CourseEntity;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private JpaCoursesRepository repository;

    @GetMapping(value="/{id}")
    public ResponseEntity<CourseEntity> getCourse(@PathVariable("id") Long id){
        log.info("------->" + id.toString());
        var result = repository.findById(id).orElseThrow();
        log.info(result.toString());
        CourseEntity course = CourseEntity.builder()
                .id(result.getId())
                .name(result.getName())
                .activity(result.getActivity())
                .dateStart(result.getDateStart())
                .build();
        log.info(course.toString());
        return ResponseEntity.ok(course);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseEntity>> getListCourses(){
        var result = repository.findAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseEntity> create(@Valid @RequestBody CourseEntity request){

        request.setDateStart(LocalDate.now());
        log.info(request.toString());
        var result = repository.save(request);
        CourseEntity course = CourseEntity.builder()
                .id(result.getId())
                .name(result.getName())
                .activity(result.getActivity())
                .dateStart(result.getDateStart())
                .build();
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.ok("Запись с ID-" + id + " была удалена...");
    }

}