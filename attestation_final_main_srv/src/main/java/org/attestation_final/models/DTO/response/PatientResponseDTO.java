package org.attestation_final.models.DTO.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientResponseDTO {
    private Long id;
    private String fio;
    private String tel;
    private String address;
    private String message;
}
