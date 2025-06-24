package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.AppointmentDTO;
import org.attestation_final.models.DTO.response.AppointmentResponseDTO;
import org.attestation_final.services.IMethodsCRUDService;
import org.springframework.stereotype.Service;

/**
 * Класс service-слоя. Реализующий основную логику программы
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentService implements IMethodsCRUDService<AppointmentResponseDTO, AppointmentDTO> {

    private  final IMethodsCRUDRest<AppointmentResponseDTO, AppointmentDTO> restClient;

    /**
     * Метод сетевого запроса к сервису Appointment Service на добавление новой записи о приеме в БД
     * @param dto - объект класса AppointmentDTO
     * @return информация о успешном создании записи на прием к врачу. Тип - AppointmentResponseDTO
     */
    @Override
    public AppointmentResponseDTO create(AppointmentDTO dto) {
        return restClient.createREST(dto);
    }

    /**
     * Метод сетевого запроса к сервису Appointment Service на обновление записи о приеме в БД
     * @param dto - объект класса AppointmentDTO
     * @return информация о успешном обновлении записи на прием к врачу. Тип - AppointmentResponseDTO
     */
    @Override
    public AppointmentResponseDTO update(AppointmentDTO dto) {
        return restClient.updateREST(dto);
    }

    /**
     * Метод сетевого запроса к сервису Appointment Service на удаление записи о приеме в БД
     * @param id - идентификатор записи в БД
     * @return информация о успешном удалении записи на прием к врачу. Тип - AppointmentResponseDTO
     */
    @Override
    public AppointmentResponseDTO delete(Long id) {
        return restClient.deleteREST(id);
    }

    /**
     * Метод сетевого запроса к сервису Appointment Service на получение записи о приеме в БД
     * @param id - идентификатор записи в БД
     * @return информация о успешном получении записи на прием к врачу. Тип - AppointmentResponseDTO
     */
    @Override
    public AppointmentResponseDTO find(Long id) {
        return restClient.findByIdREST(id);
    }
}
