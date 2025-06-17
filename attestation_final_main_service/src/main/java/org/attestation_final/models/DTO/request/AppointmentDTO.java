package org.attestation_final.models.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    Long idEmpl;
    Long idPat;
    String time;
    String description;
}
