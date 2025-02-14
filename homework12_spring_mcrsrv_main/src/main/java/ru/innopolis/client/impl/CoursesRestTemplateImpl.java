package ru.innopolis.client.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.innopolis.client.CoursesClient;
import ru.innopolis.dto.courses.CourseResponse;

import java.util.List;

@Component
@Profile("restTemplate")
public class CoursesRestTemplateImpl implements CoursesClient {

    private RestTemplate restTemplate;
    private static final String URL ="http://localhost:8090/api/v1/courses";

    @PostConstruct
    private void init(){
        restTemplate = new RestTemplate();
    }

    @Override
    public CourseResponse getCourse(Long id) {
        return restTemplate.getForObject(URL +"/" + id, CourseResponse.class);
    }

    @Override
    public List<CourseResponse> getListCourses() {
        return restTemplate.getForObject(URL, List.class);
    }
}
