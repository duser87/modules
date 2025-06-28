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
@Table(name="positions", schema = "post_service")
public class PositionEntity{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "position")
    private String position;
}