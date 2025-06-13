package ru.innopolis.services;

import ru.innopolis.models.DTO.request.AppointmentDTO;
import ru.innopolis.models.DTO.response.AppointmentResponseDTO;
import ru.innopolis.models.Entity.AppointmentEntity;

public interface AppointmentServiceInterface {
    AppointmentResponseDTO create(AppointmentDTO dto);
    AppointmentResponseDTO update(AppointmentDTO dto);
    AppointmentResponseDTO delete(AppointmentDTO dto);
    AppointmentResponseDTO findById(AppointmentDTO dto);

}
