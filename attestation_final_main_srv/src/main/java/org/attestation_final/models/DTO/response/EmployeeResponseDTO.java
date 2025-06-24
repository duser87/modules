package org.attestation_final.models.DTO.response;

import lombok.Builder;
import lombok.Data;

/**
 * Это класс, описывающий объект ответа клиентской стороне. Он имеет следующие поля:
 * - id - идентификатор записи работника в БД
 * - fio - ФИО работника, тип String
 * - tel - Тел работника, тип String
 * - message - информационное сообщение клиентской стороне
 */
@Data
@Builder
public class EmployeeResponseDTO {
    private Long id;
    private String fio;
    private String tel;
    private String message;
}
