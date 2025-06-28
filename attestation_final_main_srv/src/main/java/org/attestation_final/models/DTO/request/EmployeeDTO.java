package org.attestation_final.models.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Это класс, описывающий объект запроса с клиентской стороны. Он имеет следующие поля:
 * - id - идентификатор записи работника в БД
 * - fio - ФИО работника, тип String
 * - tel - Тел работника, тип String
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    Long id;
    String fio;
    String tel;
}
