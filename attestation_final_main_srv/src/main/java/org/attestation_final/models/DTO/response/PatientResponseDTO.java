package org.attestation_final.models.DTO.response;

import lombok.Builder;
import lombok.Data;

/**
 * Это класс, описывающий объект ответа клиентской стороне. Он имеет следующие поля:
 * - id - идентификатор записи клиента в БД
 * - fio - ФИО клиента, тип String
 * - tel - Тел клиента, тип String
 * - address - Адрес клиента, тип String
 * - message - информационное сообщение клиентской стороне
 */
@Data
@Builder
public class PatientResponseDTO {
    private Long id;
    private String fio;
    private String tel;
    private String address;
    private String message;
}
