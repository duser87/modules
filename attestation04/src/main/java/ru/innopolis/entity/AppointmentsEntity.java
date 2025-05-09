package ru.innopolis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="appointments")
public class AppointmentsEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long idEmpl;
    private Long idPat;
    private String time;
    private String description;
}
