package ru.innopolis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.EarthquakeCreateRequest;
import ru.innopolis.dto.EarthquakeResponse;
import ru.innopolis.entity.EarthquakeEntity;
import ru.innopolis.repository.EarthquakeRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
                        .time(LocalDateTime.ofEpochSecond(x.getProperties().getTime(), 0, ZoneOffset.UTC))
                        .build()).toList();

        repository.saveAll(result);
    }

    public List<EarthquakeResponse> getEarthquake(Double mag){
        List<EarthquakeEntity> list = repository.findAll().stream().filter(x -> x.getMag() > mag).toList();
        log.info(">>>" + list);
        List<EarthquakeResponse> responses = list.stream().map(x -> EarthquakeResponse.builder()
                .id(x.getId())
                .title(x.getTitle())
                .place(x.getPlace())
                .time(x.getTime())
                .mag(x.getMag())
                .build()).toList();
        log.info(">>>" + responses);
        return responses;
    }
}
