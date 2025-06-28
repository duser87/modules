package org.attestation_final.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Это класс, описывающий сущность записи на прием в БД. Он имеет следующие поля:
 * - id - идентификатор записи на прием
 * - idEmpl - id работника, к которому оформлена запись
 * - idPat - id пациента
 * - time - время записи
 * - description - описание
 * - del - флаг, указывающий на удаление записи
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="appointments", schema = "appointment_service")
public class AppointmentEntity{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "id_empl")
    private Long idEmpl;

    @Column(name = "id_pat")
    private Long idPat;

    @Column(name = "time")
    private String time;

    @Column(name = "description")
    private String description;

    @Column(name="del")
    private Boolean del;
}
