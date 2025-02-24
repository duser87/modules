package ru.innopolis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.EarthquakeCreateRequest;
import ru.innopolis.dto.EarthquakeResponse;
import ru.innopolis.entity.EarthquakeEntity;
import ru.innopolis.repository.EarthquakeRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Slf4j
@Service
public class EarthquakeService {

    private final EarthquakeRepository repository;

    public EarthquakeService(EarthquakeRepository r){
        repository = r;
    }

    public void addEarthquake(EarthquakeCreateRequest request){
        List<EarthquakeEntity> result = request.getFeatures().stream()
                .map(x -> EarthquakeEntity.builder()
                        .title(x.getProperties().getTitle())
                        .mag(x.getProperties().getMag())
                        .place(x.getProperties().getPlace())
                        .time(LocalDateTime.ofInstant(Instant.ofEpochMilli(x.getProperties().getTime()), ZoneId.systemDefault()))
                        .build()).toList();

        repository.saveAll(result);
    }

    public List<EarthquakeResponse> getEarthquake(Double mag){
        List<EarthquakeEntity> list = repository.findAll().stream().filter(x -> x.getMag() > mag).toList();
        List<EarthquakeResponse> responses = list.stream().map(x -> EarthquakeResponse.builder()
                .id(x.getId())
                .title(x.getTitle())
                .place(x.getPlace())
                .time(x.getTime())
                .mag(x.getMag())
                .build()).toList();
        return responses;
    }

//
    public List<EarthquakeEntity> findByTimeBetween(LocalDateTime timeAfter, LocalDateTime timeBefore){
        List<EarthquakeEntity> result = repository.findByTimeBetween(timeAfter, timeBefore).stream().map(x -> EarthquakeEntity.builder()
                .title(x.getTitle())
                .mag(x.getMag())
                .place(x.getPlace())
                .time(x.getTime())
                .build()).toList();
        log.info(result.toString());
        return result;
    }
}
