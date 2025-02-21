package ru.innopolis.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.innopolis.dto.EarthquakeDataRemoteHostResponse;
import ru.innopolis.repository.EarthquakeRepository;

import java.nio.file.NoSuchFileException;
import java.util.*;

@Component
public class RestClientGeoData implements CommandLineRunner {

    private EarthquakeRepository repository;

    public RestClientGeoData(EarthquakeRepository repo){
        repository = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        var res = getDataGeoJson();
        System.out.println(res);

    }



    private List<EarthquakeDataRemoteHostResponse> getDataGeoJson(){

        ParameterizedTypeReference<List<EarthquakeDataRemoteHostResponse>> typeRef = new ParameterizedTypeReference<>(){};
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
        System.out.println(x.get(0).getFeatures().get(0).getProperties());
        return  x;
    }

}
