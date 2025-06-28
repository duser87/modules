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
@Table(name="posts", schema = "post_service")
public class PostEntity{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "id_pos")
    private Long idPos;

    @Column(name = "id_empl")
    private Long idEmpl;
}