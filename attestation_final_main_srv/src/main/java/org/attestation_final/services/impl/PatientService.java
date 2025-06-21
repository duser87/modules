package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.PatientDTO;
import org.attestation_final.models.DTO.response.PatientResponseDTO;
import org.attestation_final.services.IMethodsCRUDService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientService implements IMethodsCRUDService<PatientResponseDTO, PatientDTO> {

    private  final IMethodsCRUDRest<PatientResponseDTO, PatientDTO> restClient;

    @Override
    public PatientResponseDTO create(PatientDTO dto) {
        return restClient.createREST(dto);
    }

    @Override
    public PatientResponseDTO update(PatientDTO dto) {
        return restClient.updateREST(dto);
    }

    @Override
    public PatientResponseDTO delete(Long id) {
        return restClient.deleteREST(id);
    }

    @Override
    public PatientResponseDTO find(Long id) {
        return restClient.findREST(id);
    }
}
