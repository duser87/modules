package org.attestation_final.model.DTO.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentResponseDTO {
    private Long id;
    private Long idEmpl;
    private Long idPat;
    private String time;
    private String description;
    private String message;
}
