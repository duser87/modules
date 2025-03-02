package ru.innopolis.clients.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.innopolis.clients.InfoClient;
import ru.innopolis.dto.CourseResponse;


@Component
public class CourseRestClientImpl implements InfoClient {

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
}
