package org.attestation_final.services;

import org.attestation_final.model.DTO.request.AppointmentDTO;
import org.attestation_final.model.DTO.response.AppointmentResponseDTO;

/**
 * Интерфейс, реализующий стандартные CRUD-операции при работе с сущностью AppointmentResponseDTO из БД
 */
public interface IAppointmentService {
    AppointmentResponseDTO create(AppointmentDTO dto);
    AppointmentResponseDTO update(AppointmentDTO dto);
    AppointmentResponseDTO delete(Long id);
    AppointmentResponseDTO findById(Long id);
}
