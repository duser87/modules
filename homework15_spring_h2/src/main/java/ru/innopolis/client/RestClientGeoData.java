package ru.innopolis.client;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.innopolis.dto.EarthquakeResponse;
import ru.innopolis.repository.EarthquakeRepository;

import java.nio.file.NoSuchFileException;
import java.util.List;

@Component
public class RestClientGeoData implements CommandLineRunner {

    @Autowired
    private EarthquakeRepository repository;
    RestClient restClient;
    List<EarthquakeResponse> responseList;

    @Value("${geojson.api.url}")
    private static String urlGeo;


    @Override
    public void run(String... args) throws Exception {
        initRestClient();
        var result = getDataGeoJson();

        repository.flush();
    }

    private void initRestClient(){
        restClient.get().uri(urlGeo).retrieve().body(EarthquakeResponse.class);
    }

    private List<EarthquakeResponse> getDataGeoJson(){
        ParameterizedTypeReference ref = new ParameterizedTypeReference<>() {
        };
        var result = restClient.get().exchange((clientRequest, clientResponse) -> {
            if(clientResponse.getStatusCode().is2xxSuccessful()){
                return clientResponse.bodyTo(ref);
            }
            if(clientResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)){
                throw new NoSuchFileException(" ---> Ничего не найдено!");
            }
            return List.of();
        });
    }
}
