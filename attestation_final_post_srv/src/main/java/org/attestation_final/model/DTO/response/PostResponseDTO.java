package org.attestation_final.model.DTO.response;

import lombok.Builder;
import lombok.Data;

/**
 * Это класс, описывающий объект ответа клиентской стороне. Он имеет следующие поля:
 * - id - идентификатор записи на прием
 * - idPost - id должности, тип Long
 * - idEmpl - id работника, тип Long
 * - message - поле информационного сообщения
 */
@Data
@Builder
public class PostResponseDTO{
    private Long id;
    private Long idEmpl;
    private Long idPos;
    private String message;
}
