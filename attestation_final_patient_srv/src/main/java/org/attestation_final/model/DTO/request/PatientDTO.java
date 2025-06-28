package org.attestation_final.model.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Это класс, описывающий объект запроса с клиентской стороны. Он имеет следующие поля:
 * - id - идентификатор записи на прием
 * - fio - ФИО клиента, тип String
 * - tel - Номер телефона клиента, тип String
 * - address - адрес клиента, тип String
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
