package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.model.DTO.request.AppointmentDTO;
import org.attestation_final.model.DTO.response.AppointmentResponseDTO;
import org.attestation_final.services.AppointmentServiceInterface;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentServiceInterface {
    @Override
    public AppointmentResponseDTO create(AppointmentDTO dto) {
        return null;
    }

    @Override
    public AppointmentResponseDTO update(AppointmentDTO dto) {
        return null;
    }

    @Override
    public AppointmentResponseDTO delete(AppointmentDTO dto) {
        return null;
    }

    @Override
    public AppointmentResponseDTO findById(Long id) {
        return null;
    }
}
