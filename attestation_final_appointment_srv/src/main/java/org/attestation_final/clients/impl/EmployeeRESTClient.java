package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IGetDataRest;
import org.attestation_final.model.DTO.response.EmployeeResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;


/**
 *  Класс-компонент, реализующий метод интерфейса IGetDataRest запросы по URL- localhost:8082/api/v1/services/employee
 *
 */
@Component
public class EmployeeRESTClient implements IGetDataRest<EmployeeResponseDTO> {

    RestClient restClient;
    private static final String URL = "http://localhost:8082/api/v1/services/employee";

    /**
     *  Метод инициализации RestClient
     */
    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных о работнике.
     * @param id - идентификатор работника
     * @return - объект класса EmployeeResponseDTO, содержащий всю информацию о работнике
     */
    @Override
    public EmployeeResponseDTO findByIdREST(Long id) {
        return restClient.get()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(EmployeeResponseDTO.class);
    }
}
