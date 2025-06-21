package org.attestation_final.clients;

import org.attestation_final.models.DTO.request.AppointmentDTO;
import org.attestation_final.models.DTO.response.AppointmentResponseDTO;

public interface IMethodsCRUDRest<T, V> {
    T createREST(V dto);
    T updateREST(V dto);
    T deleteREST(Long id);
    T findREST(Long id);
}
