package org.attestation_final.clients;

import org.attestation_final.models.DTO.request.AppointmentDTO;
import org.attestation_final.models.DTO.response.AppointmentResponseDTO;

/**
 * Интерфейс, определяющий метод реализующий HTTP-запросы к другим сервисам для выполнения соотвктствующих  CRUD-операций
 */
public interface IMethodsCRUDRest<T, V> {
    T createREST(V dto);
    T updateREST(V dto);
    T deleteREST(Long id);
    T findByIdREST(Long id);
}
