package org.attestation_final.services;

import org.attestation_final.model.DTO.request.PostDTO;
import org.attestation_final.model.DTO.response.PostResponseDTO;

/**
 * Интерфейс, определяющий стандартные CRUD-операции
 */
public interface IPostService {
    PostResponseDTO create(PostDTO dto);
    PostResponseDTO delete(Long id);
}
