package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.AppointmentDTO;
import org.attestation_final.models.DTO.response.AppointmentResponseDTO;
import org.attestation_final.services.IMethodsCRUDService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentService implements IMethodsCRUDService<AppointmentResponseDTO, AppointmentDTO> {

    private  final IMethodsCRUDRest<AppointmentResponseDTO, AppointmentDTO> restClient;

    @Override
    public AppointmentResponseDTO create(AppointmentDTO dto) {
        return restClient.createREST(dto);
    }

    @Override
    public AppointmentResponseDTO update(AppointmentDTO dto) {
        return restClient.updateREST(dto);
    }

    @Override
    public AppointmentResponseDTO delete(Long id) {
        return restClient.deleteREST(id);
    }

    @Override
    public AppointmentResponseDTO find(Long id) {
        return restClient.findByIdREST(id);
    }
}
