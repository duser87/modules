package org.attestation_final.clients.impl;

import jakarta.annotation.PostConstruct;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.AppointmentDTO;
import org.attestation_final.models.DTO.response.AppointmentResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 *  Класс-компонент, реализующий метод интерфейса IMethodsCRUDRest запросы по URL- localhost:8081/api/v1/services/appointment
 *
 */
@Component
public class AppointmentRESTClient implements IMethodsCRUDRest<AppointmentResponseDTO, AppointmentDTO> {

    RestClient restClient;
    private static final String URL = "http://localhost:8081/api/v1/services/appointment";

    /**
     *  Метод инициализации RestClient
     */
    @PostConstruct
    private void init(){
        restClient = RestClient.builder().baseUrl(URL).build();
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных запис на прием. Создание записи на прием
     * @param dto - объект типа AppointmentDTO, параметры записи на прием
     * @return - объект класса AppointmentResponseDTO, содержащий всю информацию о записи на прием
     */
    @Override
    public AppointmentResponseDTO createREST(AppointmentDTO dto) {
        return restClient.post()
                .uri(URL + "/create")
                .body(dto)
                .retrieve()
                .body(AppointmentResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных запис на прием. Обновление записи на прием
     * @param dto - объект типа AppointmentDTO, параметры записи на прием
     * @return - объект класса AppointmentResponseDTO, содержащий обновленную информацию о записи на прием
     */
    @Override
    public AppointmentResponseDTO updateREST(AppointmentDTO dto) {
        return restClient.put()
                .uri(URL + "/update")
                .body(dto)
                .retrieve()
                .body(AppointmentResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных запис на прием. Удаление записи на прием
     * @param id - идентификатор записи на прием
     * @return - объект класса AppointmentResponseDTO, содержащий информацию о удалении записи на прием
     */
    @Override
    public AppointmentResponseDTO deleteREST(Long id) {
        return restClient.delete()
                .uri(URL + "/delete/{id}", id)
                .retrieve()
                .body(AppointmentResponseDTO.class);
    }

    /**
     *  Метод, выполняющий сетевой запрос к сервису данных запис на прием. Получение информации о записи на прием
     * @param id - идентификатор записи на прием
     * @return - объект класса AppointmentResponseDTO, содержащий информацию о  записи на прием
     */
    @Override
    public AppointmentResponseDTO findByIdREST(Long id) {
        return restClient.get()
                .uri(URL + "/{id}", id)
                .retrieve()
                .body(AppointmentResponseDTO.class);
    }
}
