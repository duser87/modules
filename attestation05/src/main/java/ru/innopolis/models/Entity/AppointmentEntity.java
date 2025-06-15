package ru.innopolis.models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="appointments", schema = "clinic")
public class AppointmentEntity implements Serializable {
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
