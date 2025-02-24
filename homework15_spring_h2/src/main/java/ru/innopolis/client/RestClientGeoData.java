package ru.innopolis.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.innopolis.dto.EarthquakeDataRemoteHostResponse;
import ru.innopolis.entity.EarthquakeEntity;
import ru.innopolis.repository.EarthquakeRepository;
import ru.innopolis.service.EarthquakeService;

import java.nio.file.NoSuchFileException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Slf4j
@Component
public class RestClientGeoData implements CommandLineRunner {

    private final EarthquakeRepository repository;

    public RestClientGeoData(EarthquakeRepository repo){
        repository = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        var res = getDataGeoJson();
        log.info(res.toString());
        List<EarthquakeEntity> list = res.getFeatures().stream().map( x -> EarthquakeEntity.builder()
                .title(x.getProperties().getTitle())
                .mag(x.getProperties().getMag())
                .place(x.getProperties().getPlace())
                .time(LocalDateTime.ofInstant(Instant.ofEpochMilli(x.getProperties().getTime()), ZoneId.systemDefault()))
                .build()).toList();
        log.info(list.toString());
        repository.saveAll(list);
    }



    private EarthquakeDataRemoteHostResponse getDataGeoJson(){

        ParameterizedTypeReference<EarthquakeDataRemoteHostResponse> typeRef = new ParameterizedTypeReference<>(){};
        var result = RestClient.builder().build();
        var x =  result
                .get()
                .uri("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson")
                .exchange((clientRequest, clientResponse) -> {
            if(clientResponse.getStatusCode().is2xxSuccessful()){
                System.out.println(clientResponse);
                return clientResponse.bodyTo(typeRef);
            }
            if(clientResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)){
                throw new NoSuchFileException(" ---> Ничего не найдено!");
            }
            return null;
        });
        return  x;
    }

}
