package org.attestation_final.model.DTO.response;

import lombok.Builder;
import lombok.Data;

/**
 * Это класс, описывающий объект ответа клиентской стороне. Он имеет следующие поля:
 * - id - идентификатор записи на прием
 * - fio - ФИО клиента, тип String
 * - tel - Номер телефона клиента, тип String
 * - address - адрес клиента, тип String
 * - message - информационное сообщение
 */
@Data
@Builder
public class PatientResponseDTO{
    private Long id;
    private String fio;
    private String tel;
    private String address;
    private String message;
}