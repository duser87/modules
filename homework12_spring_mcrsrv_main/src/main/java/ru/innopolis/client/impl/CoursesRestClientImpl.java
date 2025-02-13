package ru.innopolis.client.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.innopolis.client.CoursesClient;
import ru.innopolis.dto.courses.CourseResponse;

import java.nio.file.NoSuchFileException;
import java.util.List;

@Component
public class CoursesRestClientImpl implements CoursesClient {

    RestClient restClient;
    private static final String URL = "http://localhost:8090/api/v1/courses";

    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    @Override
    public CourseResponse getCourse(Long id) {
        return restClient.get().uri("/" + id.intValue()).retrieve().body(CourseResponse.class);
    }

    @Override
    public List<CourseResponse> getListCourses() {
        ParameterizedTypeReference<List<CourseResponse>> typeRef = new ParameterizedTypeReference<>(){};
        return restClient.get().exchange((clientRequest, clientResponse) -> {
            if(clientResponse.getStatusCode().is2xxSuccessful()){
                return clientResponse.bodyTo(typeRef);
            }
            if(clientResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)){
                throw new NoSuchFileException(" ---> Ничего не найдено!");
            }
            return List.of();
        });
    }
}
