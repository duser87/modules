package org.attestation_final.model.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Это класс, описывающий объект запроса создания записи на прием в БД. Он имеет следующие поля:
 * - id - идентификатор записи на прием
 * - idEmpl - id работника, к которому оформлена запись
 * - idPat - id пациента
 * - time - время записи
 * - description - описание
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    Long idEmpl;
    Long idPat;
    String time;
    String description;
}
