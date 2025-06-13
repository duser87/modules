package ru.innopolis.services;

import ru.innopolis.models.DTO.request.EmployeeDTO;
import ru.innopolis.models.DTO.response.EmployeeResponseDTO;

public interface EmployeeServiceInterface {
    EmployeeResponseDTO create(EmployeeDTO dto);
    EmployeeResponseDTO update(EmployeeDTO dto);
    EmployeeResponseDTO delete(EmployeeDTO dto);
    EmployeeResponseDTO findById(Long id);
}
