package ru.innopolis.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate dateStart;
    private Boolean archive;
}
