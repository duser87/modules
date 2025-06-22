package org.attestation_final.services;

import org.attestation_final.model.DTO.request.EmployeeDTO;
import org.attestation_final.model.DTO.response.EmployeeResponseDTO;

public interface IEmployeeService {
    EmployeeResponseDTO create(EmployeeDTO dto);
    EmployeeResponseDTO update(EmployeeDTO dto);
    EmployeeResponseDTO delete(Long id);
    EmployeeResponseDTO findById(Long id);
}
