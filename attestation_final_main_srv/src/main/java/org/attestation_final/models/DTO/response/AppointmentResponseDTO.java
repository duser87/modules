package org.attestation_final.models.DTO.response;

import lombok.Builder;
import lombok.Data;

/**
 * Это класс, описывающий объект ответа с клиентской стороне. Он имеет следующие поля:
 * - id - идентификатор записи на прием в БД
 * - idEmpl - id работника, к которому оформлена запись
 * - idPat - id пациента
 * - time - время записи
 * - description - описание
 * - message - информационное сообщение клиентской стороне
 */
@Data
@Builder
public class AppointmentResponseDTO {
    private Long id;
    private Long idEmpl;
    private Long idPat;
    private String time;
    private String description;
    private String message;
}
