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
@Table(name="doctors", schema = "med")
public class DoctorEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "id_pos")
    private Long idPos;

    @Column(name = "fio_d")
    private String fioDoc;

    @Column(name = "tel_d")
    private String telDoc;
}
