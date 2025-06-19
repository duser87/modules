package org.attestation_final.clients.appointment;

import org.attestation_final.models.DTO.request.AppointmentDTO;
import org.attestation_final.models.DTO.response.AppointmentResponseDTO;

public interface IAppointmentClient {
    AppointmentResponseDTO createREST(AppointmentDTO dto);
    AppointmentResponseDTO updateREST(AppointmentDTO dto);
    AppointmentResponseDTO deleteREST(Long id);
    AppointmentResponseDTO findREST(Long id);
}
