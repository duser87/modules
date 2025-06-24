package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.PatientDTO;
import org.attestation_final.models.DTO.response.PatientResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 *  Класс-компонент, реализующий метод интерфейса IMethodsCRUDRest запросы по URL- localhost:8083/api/v1/services/patient
 *
 */
@Component
public class PatientRESTClient implements IMethodsCRUDRest<PatientResponseDTO, PatientDTO> {

    RestClient restClient;
    private static final String URL = "http://localhost:8083/api/v1/services/patient";

    /**
     *  Метод инициализации RestClient
     */
    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных о клиенте. Создание записи в БД о клиенте
     * @param dto - объект типа PatientDTO, параметры для создания записи о клиенте
     * @return - объект класса PatientResponseDTO, содержащий всю информацию о клиенте
     */
    @Override
    public PatientResponseDTO createREST(PatientDTO dto) {
        return restClient.post()
                .uri(URL + "/create")
                .body(dto)
                .retrieve()
                .body(PatientResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных о клиенте. Обновление записи в БД о клиенте
     * @param dto - объект типа PatientDTO, параметры для обновления записи о клиенте
     * @return - объект класса PatientResponseDTO, содержащий всю информацию о клиенте
     */
    @Override
    public PatientResponseDTO updateREST(PatientDTO dto) {
        return restClient.put()
                .uri(URL + "/update")
                .body(dto)
                .retrieve()
                .body(PatientResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных о клиенте. Удаление записи в БД о клиенте
     * @param id - идентификатор записи клиента в БД
     * @return - объект класса PatientResponseDTO, содержащий всю информацию о клиенте
     */
    @Override
    public PatientResponseDTO deleteREST(Long id) {
        return restClient.delete()
                .uri(URL + "/delete/{id}", id)
                .retrieve()
                .body(PatientResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных о клиенте. Получение записи в БД о клиенте
     * @param id - идентификатор записи клиента в БД
     * @return - объект класса PatientResponseDTO, содержащий всю информацию о клиенте
     */
    @Override
    public PatientResponseDTO findByIdREST(Long id) {
        return restClient.get()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(PatientResponseDTO.class);
    }
}
