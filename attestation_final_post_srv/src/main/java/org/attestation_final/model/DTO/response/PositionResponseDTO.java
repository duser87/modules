package org.attestation_final.model.DTO.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PositionResponseDTO{
    private Long id;
    private String position;
    private String message;
}
