package ru.innopolis.clients.impl;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.innopolis.clients.InfoStudentClient;
import ru.innopolis.dto.CourseResponse;
import ru.innopolis.dto.ListCoursesStudentResponse;
import ru.innopolis.dto.StudentResponse;

import java.nio.file.NoSuchFileException;
import java.util.List;

@Slf4j
@Component
public class StudentRestClientImpl implements InfoStudentClient {

    RestClient restClient;
    private static final String URL = "http://localhost:8080/api/v1/student";

    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    @Override
    public List<StudentResponse> getListStudent() {
        ParameterizedTypeReference<List<StudentResponse>> typeRef = new ParameterizedTypeReference<>(){};
        return restClient.get().uri("/all").exchange((clientRequest, clientResponse) -> {
            if(clientResponse.getStatusCode().is2xxSuccessful()){
                return clientResponse.bodyTo(typeRef);
            }
            if(clientResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)){
                throw new NoSuchFileException(" ---> Ничего не найдено!");
            }
            return List.of();
        });
    }

    @Override
    public List<ListCoursesStudentResponse> getListCoursesStudent() {
        ParameterizedTypeReference<List<ListCoursesStudentResponse>> typeRef = new ParameterizedTypeReference<>(){};
        return restClient.get().uri("/record/all").exchange((clientRequest, clientResponse) -> {
            if(clientResponse.getStatusCode().is2xxSuccessful()){
                log.info(clientResponse.toString());
                return clientResponse.bodyTo(typeRef);
            }
            if(clientResponse.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)){
                throw new NoSuchFileException(" ---> Ничего не найдено!");
            }
            return List.of();
        });
    }
}
