package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.PostDTO;
import org.attestation_final.models.DTO.response.PatientResponseDTO;
import org.attestation_final.models.DTO.response.PostResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 *  Класс-компонент, реализующий метод интерфейса IMethodsCRUDRest запросы по URL- localhost:8084/api/v1/services/post
 *
 */
@Component
public class PostRESTClient implements IMethodsCRUDRest<PostResponseDTO, PostDTO> {
    RestClient restClient;
    private static final String URL = "http://localhost:8084/api/v1/services/post";

    /**
     *  Метод инициализации RestClient
     */
    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных должности. Создание записи в БД о должности
     * @param dto - объект типа PostDTO, параметры для создания записи о должности
     * @return - объект класса PostResponseDTO, содержащий всю информацию о должности
     */
    @Override
    public PostResponseDTO createREST(PostDTO dto) {
        return restClient.post()
                .uri(URL)
                .body(dto)
                .retrieve()
                .body(PostResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных должности. Обновление записи в БД о должности
     * @param dto - объект типа PostDTO, параметры для обновления записи о должности
     * @return - объект класса PostResponseDTO, содержащий всю информацию о должности
     */
    @Override
    public PostResponseDTO updateREST(PostDTO dto) {
        return restClient.put()
                .uri(URL)
                .body(dto)
                .retrieve()
                .body(PostResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных должности. Удаление записи в БД о должности
     * @param id - идентификатор записи должности и работника
     * @return - объект класса PostResponseDTO, содержащий всю информацию о должности
     */
    @Override
    public PostResponseDTO deleteREST(Long id) {
        return restClient.delete()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(PostResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных должности. Получение записи в БД о должности
     * @param id - идентификатор записи должности и работника
     * @return - объект класса PostResponseDTO, содержащий всю информацию о должности
     */
    @Override
    public PostResponseDTO findByIdREST(Long id) {
        return restClient.get()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(PostResponseDTO.class);
    }
}
