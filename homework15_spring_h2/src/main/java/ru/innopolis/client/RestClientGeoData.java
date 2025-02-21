package ru.innopolis.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import ru.innopolis.dto.EarthquakeResponse;
import ru.innopolis.entity.EarthquakeEntity;
import ru.innopolis.repository.EarthquakeRepository;

import java.nio.file.NoSuchFileException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RestClientGeoData implements CommandLineRunner {

    private final EarthquakeRepository repository;

    public RestClientGeoData(EarthquakeRepository repo){
        repository = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        var res = getDataGeoJson();
        System.out.println(res);
        // Как получить json с удаленного сайта я не смог реализовать. Единственное
        // что получилось, принять все данные  о землетрясениях в формате String.
        // Но что делать дальше - не знаю. Пробовал в json перевести, но не смог решить задачу.
        // Спрашивал в группе (эмоциональный чат), все молчат.
    }


    // String
    private List<EarthquakeResponse> getDataGeoJson(){
        // String
//        ParameterizedTypeReference<List<EarthquakeResponse>> typeRef = new ParameterizedTypeReference<>(){};
//        var result = RestClient.builder().build();
//        return result.get()
//                .uri("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson")
//                .exchange((clientRequest, clientResponse) -> {
//            if(clientResponse.getStatusCode().is2xxSuccessful()){
//                System.out.println(clientResponse);
//                return clientResponse.bodyTo(typeRef);
//            }
//            if(clientResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)){
//                throw new NoSuchFileException(" ---> Ничего не найдено!");
//            }
//            return null;
//        });
        return  null;
    }

}
