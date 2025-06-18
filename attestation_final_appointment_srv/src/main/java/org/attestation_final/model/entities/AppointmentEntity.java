package org.attestation_final.model.entities;

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
@Table(name="appointments", schema = "appointment_service")
public class AppointmentEntity {
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
