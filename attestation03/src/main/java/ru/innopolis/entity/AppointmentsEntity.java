package ru.innopolis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="appointments", schema = "med")
public class AppointmentsEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "id_d")
    private Long idDoc;

    @Column(name = "id_p")
    private Long idPac;

    @Column(name = "time")
    private String time;

    @Column(name = "description")
    private String description;
}
