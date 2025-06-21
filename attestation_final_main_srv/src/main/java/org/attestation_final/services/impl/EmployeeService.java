package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.clients.IMethodsCRUDRest;
import org.attestation_final.models.DTO.request.EmployeeDTO;
import org.attestation_final.models.DTO.response.EmployeeResponseDTO;
import org.attestation_final.services.IMethodsCRUDService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService implements IMethodsCRUDService<EmployeeResponseDTO, EmployeeDTO> {

    private  final IMethodsCRUDRest<EmployeeResponseDTO, EmployeeDTO> restClient;

    @Override
    public EmployeeResponseDTO create(EmployeeDTO dto) {
        return restClient.createREST(dto);
    }

    @Override
    public EmployeeResponseDTO update(EmployeeDTO dto) {
        return restClient.updateREST(dto);
    }

    @Override
    public EmployeeResponseDTO delete(Long id) {
        return restClient.deleteREST(id);
    }

    @Override
    public EmployeeResponseDTO find(Long id) {
        return restClient.findREST(id);
    }
}
