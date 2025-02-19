package ru.innopolis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.EarthquakeCreateRequest;
import ru.innopolis.dto.EarthquakeResponse;
import ru.innopolis.service.EarthquakeService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/earthquake")
public class EarthquakeController {
    @Autowired
    private EarthquakeService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addEarthquake(@RequestBody EarthquakeCreateRequest request){
        service.addEarthquake(request);
        return ResponseEntity.ok(">>> Данные добавлены");
    }

    @GetMapping(value ="/{mag}")
    public ResponseEntity<List<EarthquakeResponse>> getEarthquake(@PathVariable("mag") Double mag){
        log.info(">>> Пришел запрос на контроллер");
        var response = service.getEarthquake(mag);
        log.info(">>> Ответ от сервиса");
        return ResponseEntity.ok(response);
    }
}
