package org.attestation_final.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Это класс, описывающий сущность работника в БД. Он имеет следующие поля:
 * - id - идентификатор записи на прием
 * - fio - ФИО работника
 * - tel - номер телефона работника
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="employees", schema = "employee_service")
public class EmployeeEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "tel")
    private String tel;

}