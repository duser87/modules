package org.attestation_final.services;

import org.attestation_final.models.DTO.request.AppointmentDTO;
import org.attestation_final.models.DTO.response.AppointmentResponseDTO;

public interface AppointmentServiceInterface {
    AppointmentResponseDTO create(AppointmentDTO dto);
    AppointmentResponseDTO update(AppointmentDTO dto);
    AppointmentResponseDTO delete(AppointmentDTO dto);
    AppointmentResponseDTO findById(Long id);
}
