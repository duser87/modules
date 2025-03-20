package ru.innopolis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.dto.CoursesResponse;
import ru.innopolis.dto.LkDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LkController {

    @GetMapping("/lk")
    public ResponseEntity<LkDto> getLk(){
        var response = new LkDto();
        response.setCourses(List.of(CoursesResponse.builder()
                .id(1L)
                .name("Анатомия")
                .build()));

        return ResponseEntity.ok(response);
    }
}
