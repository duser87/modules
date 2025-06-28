package org.attestation_final.model.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Это класс, описывающий объект запроса с клиентской стороны. Он имеет следующие поля:
 * - id - идентификатор записи на прием
 * - idPost - id должности, тип Long
 * - idEmpl - id работника, тип Long
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    Long id;
    Long idPost;
    Long idEmpl;
}
