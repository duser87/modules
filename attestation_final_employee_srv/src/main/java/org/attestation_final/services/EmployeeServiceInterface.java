package org.attestation_final.services;

import org.attestation_final.model.DTO.request.EmployeeDTO;
import org.attestation_final.model.DTO.response.EmployeeResponseDTO;

public interface EmployeeServiceInterface {
    EmployeeResponseDTO create(EmployeeDTO dto);
    EmployeeResponseDTO update(EmployeeDTO dto);
    EmployeeResponseDTO delete(EmployeeDTO dto);
    EmployeeResponseDTO findById(Long id);
}
