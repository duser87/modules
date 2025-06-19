package org.attestation_final.services;

import org.attestation_final.model.DTO.request.PositionDTO;
import org.attestation_final.model.DTO.response.PositionResponseDTO;

public interface IPositionService {
    PositionResponseDTO create(PositionDTO dto);
    PositionResponseDTO delete(PositionDTO dto);
}
