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
 * Это класс, описывающий сущность должности работников поликлинники в БД. Он имеет следующие поля:
 * - id - идентификатор
 * - position - наименование должности
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="positions")
public class PositionEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String position;
}
