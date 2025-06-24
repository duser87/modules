package org.attestation_final.models.DTO.response;

import lombok.Builder;
import lombok.Data;

/**
 * Это класс, описывающий объект ответа клиентской стороне. Он имеет следующие поля:
 * - id - идентификатор записи о должности в БД
 * - idPost - идентификатор должности, тип Long
 * - idEmpl - идентификатор работнника, тип Long
 * - message - информационное сообщение клиентской стороне
 */
@Data
@Builder
public class PostResponseDTO {
    private Long id;
    private Long idEmpl;
    private Long idPos;
    private String message;
}
