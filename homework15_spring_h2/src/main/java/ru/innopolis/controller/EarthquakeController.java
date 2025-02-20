package ru.innopolis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.EarthquakeCreateRequest;
import ru.innopolis.dto.EarthquakeResponse;
import ru.innopolis.dto.EarthquakeTimeRequest;
import ru.innopolis.entity.EarthquakeEntity;
import ru.innopolis.service.EarthquakeService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
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
        var response = service.getEarthquake(mag);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/time", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EarthquakeResponse>> getEarthquakeByPeriodTime(@RequestBody EarthquakeTimeRequest request){
        List<EarthquakeEntity> result = service.findByTimeBetween(request.getTime1(), request.getTime2());
        List<EarthquakeResponse> response = result.stream().map( x -> EarthquakeResponse.builder()
                .id(x.getId())
                .title(x.getTitle())
                .time(x.getTime())
                .place(x.getPlace())
                .mag(x.getMag())
                .build()).toList();
        return ResponseEntity.ok(response);
    }
}
