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
 * Это класс, описывающий сущность пациента в БД. Он имеет следующие поля:
 * - id - идентификатор
 * - fio - Ф.И.О. пациента
 * - tel - номер телефона пациента
 * - address - адрес пациента
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="patients")
public class PatientEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String fio;
    private String tel;
    private String address;
}
