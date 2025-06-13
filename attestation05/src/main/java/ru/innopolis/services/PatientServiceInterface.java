package ru.innopolis.services;

import ru.innopolis.models.DTO.request.PatientDTO;
import ru.innopolis.models.DTO.response.PatientResponseDTO;
import ru.innopolis.models.Entity.PatientEntity;

public interface PatientServiceInterface {
    PatientResponseDTO create(PatientDTO dto);
    PatientResponseDTO update(PatientDTO dto);
    PatientResponseDTO delete(PatientDTO dto);
    PatientResponseDTO findById(PatientDTO dto);
}
