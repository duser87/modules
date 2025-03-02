package ru.innopolis.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.clients.InfoClient;
import ru.innopolis.dto.InfoResponse;
import ru.innopolis.repositories.JpaInfoRepository;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/info")
public class InfoController {

    private final JpaInfoRepository repository;
    private final InfoClient infoClient;

    public InfoController(JpaInfoRepository r,
                          InfoClient c){
        repository = r;
        infoClient = c;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoResponse> getCourse(@PathVariable Long id){
        var course = infoClient.getCourse(id);
        var info = repository.findById(id).orElseThrow();
        InfoResponse result = InfoResponse.builder()
                .id(info.getId())
                .name(course.getName())
                .dateStart(info.getDateStart())
                .archive(info.getArchive())
                .build();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/start/{id}")
    public ResponseEntity<InfoResponse> getCourseStart(@PathVariable("id") Long id){
        var course = infoClient.getCourse(id);
        var infoCourse = repository.findById(id).orElseThrow();
        var time = LocalDate.now();

        InfoResponse response = new InfoResponse();
        response.setId(infoCourse.getId());
        response.setName(course.getName());
        response.setDateStart(infoCourse.getDateStart());
        response.setArchive(infoCourse.getArchive());

        if (infoCourse.getDateStart().equals(time) & !infoCourse.getArchive()){
            response.setMsg("Курс открыт!");
        } else if (!infoCourse.getDateStart().equals(time) & !infoCourse.getArchive()){
            response.setMsg("Курс пока еще закрыт");
        } else{
            response.setMsg("Курс в архиве");
        }
        return ResponseEntity.ok(response);
    }

}
