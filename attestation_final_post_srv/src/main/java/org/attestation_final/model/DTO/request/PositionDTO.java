package org.attestation_final.model.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Это класс, описывающий объект запроса с клиентской стороны. Он имеет следующие поля:
 * - id - идентификатор записи на прием
 * - description - название должности, тип String
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO {

    Long id;
    String description;

}
