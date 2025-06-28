package org.attestation_final.models.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Это класс, описывающий объект запроса с клиентской стороны. Он имеет следующие поля:
 * - id - идентификатор записи клиента в БД
 * - fio - ФИО клиента, тип String
 * - tel - Тел клиента, тип String
 * - address - Адрес клиента, тип String
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    Long id;
    String fio;
    String tel;
    String address;
}
