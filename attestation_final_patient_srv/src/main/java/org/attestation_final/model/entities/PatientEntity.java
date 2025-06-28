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
@Table(name="patients", schema = "patient_service")
public class PatientEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "tel")
    private String tel;

    @Column(name = "address")
    private String address;
}
