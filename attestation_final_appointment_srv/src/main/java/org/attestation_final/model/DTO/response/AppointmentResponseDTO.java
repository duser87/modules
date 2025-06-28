package org.attestation_final.model.DTO.response;

import lombok.Builder;
import lombok.Data;

/**
 * Это класс, описывающий объект ответа клиентской стороне о записи на прием в БД. Он имеет следующие поля:
 * - id - идентификатор записи на прием
 * - idEmpl - id работника, к которому оформлена запись
 * - idPat - id пациента
 * - time - время записи
 * - description - описание
 * - message - информация об успешном выполнении
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
