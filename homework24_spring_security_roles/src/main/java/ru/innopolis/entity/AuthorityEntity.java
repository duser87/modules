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
@Table(name = "authorities", schema = "security")
public class AuthorityEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "id_student")
    private Long idStudent;

    @Column(name = "username")
    private String username;

    @Column(name = "authority")
    private String authority;
}
