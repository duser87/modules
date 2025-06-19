package org.attestation_final.services;

import org.attestation_final.model.DTO.request.PatientDTO;
import org.attestation_final.model.DTO.response.PatientResponseDTO;

public interface IPatientService {
    PatientResponseDTO create(PatientDTO dto);
    PatientResponseDTO update(PatientDTO dto);
    PatientResponseDTO delete(PatientDTO dto);
    PatientResponseDTO findById(Long id);
}
