package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IGetDataRest;
import org.attestation_final.model.DTO.response.PatientResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;


/**
 *  Класс компонента, реализующий метод интерфейса IGetDataRest запросы по URL- localhost:8083/api/v1/services/patient
 *
 */
@Component
public class PatientRestClient implements IGetDataRest<PatientResponseDTO> {

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
     *  Метод, выполняющий сетевой запрос к сервису данных о пациенте.
     * @param id - идентификатор клиента в сервисе пациентов
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
