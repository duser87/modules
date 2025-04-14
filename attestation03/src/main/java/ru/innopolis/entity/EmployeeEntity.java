package ru.innopolis.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="employees", schema = "med")
public class EmployeeEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "id_pos")
    private Long idPos;

    @Column(name = "fio_empl")
    private String fioEmpl;

    @Column(name = "tel_empl")
    private String telEmpl;
}
