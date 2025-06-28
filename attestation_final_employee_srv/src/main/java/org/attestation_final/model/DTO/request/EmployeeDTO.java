package org.attestation_final.model.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Это класс, описывающий объект запроса с клиентской стороны. Он имеет следующие поля:
 * - id - идентификатор записи нового работника
 * - fio - ФИО нового работника, тип поля String
 * - tel - номер нового работника, тип поля String
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    Long id;
    String fio;
    String tel;

}