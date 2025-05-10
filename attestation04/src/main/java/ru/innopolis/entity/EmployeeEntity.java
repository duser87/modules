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
 * Это класс, описывающий сущность работника в БД. Он имеет следующие поля:
 * - id - идентификатор
 * - idPos - идентификатор должности
 * - fioEmpl - Ф.И.О. работника
 * - telEmpl - телефон работника
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long idPos;
    private String fioEmpl;
    private String telEmpl;
}
