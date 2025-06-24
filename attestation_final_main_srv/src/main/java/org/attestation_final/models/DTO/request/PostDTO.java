package org.attestation_final.models.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Это класс, описывающий объект запроса с клиентской стороны. Он имеет следующие поля:
 * - id - идентификатор записи о должности в БД
 * - idPost - идентификатор должности, тип Long
 * - idEmpl - идентификатор работнника, тип Long
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    Long id;
    Long idPost;
    Long idEmpl;
}
