package org.attestation_final.model.DTO.response;

import lombok.Builder;
import lombok.Data;

/**
 * Это класс, описывающий объект ответа клиентской стороне. Он имеет следующие поля:
 * - id - идентификатор записи на прием
 * - description - название должности, тип String
 * - message - поле информационного сообщения
 */
@Data
@Builder
public class PositionResponseDTO{
    private Long id;
    private String position;
    private String message;
}
