package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.EmployeeDTO;
import org.attestation_final.models.DTO.response.EmployeeResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 *  Класс-компонент, реализующий метод интерфейса IMethodsCRUDRest запросы по URL- localhost:8082/api/v1/services/employee
 *
 */
@Component
public class EmployeeRESTClient implements IMethodsCRUDRest<EmployeeResponseDTO, EmployeeDTO> {

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
     *  Метод, выполняющий сетевой запрос к сервису данных о работнике. Создание записи в БД о работнике
     * @param dto - объект типа EmployeeDTO, параметры для создания записи о работнике
     * @return - объект класса EmployeeResponseDTO, содержащий всю информацию о работнике
     */
    @Override
    public EmployeeResponseDTO createREST(EmployeeDTO dto) {
        return restClient.post()
                .uri(URL)
                .body(dto)
                .retrieve()
                .body(EmployeeResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных о работнике. Обновление записи в БД о работнике
     * @param dto - объект типа EmployeeDTO, параметры для обновления записи о работнике
     * @return - объект класса EmployeeResponseDTO, содержащий обновленную информацию о работнике
     */
    @Override
    public EmployeeResponseDTO updateREST(EmployeeDTO dto) {
        return restClient.put()
                .uri(URL)
                .body(dto)
                .retrieve()
                .body(EmployeeResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных о работнике. Удаление записи в БД о работнике
     * @param id - идентификатор работника в БД
     * @return - объект класса EmployeeResponseDTO, содержащий информацию о удаленном работнике
     */
    @Override
    public EmployeeResponseDTO deleteREST(Long id) {
        return restClient.delete()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(EmployeeResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных о работнике. Получение записи в БД о работнике
     * @param id - идентификатор работника в БД
     * @return - объект класса EmployeeResponseDTO, содержащий информацию о работнике
     */
    @Override
    public EmployeeResponseDTO findByIdREST(Long id) {
        return restClient.get()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(EmployeeResponseDTO.class);
    }
}
