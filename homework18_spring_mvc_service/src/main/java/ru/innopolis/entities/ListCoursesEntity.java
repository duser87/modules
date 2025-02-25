package ru.innopolis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCoursesEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Long id_student;

    @NotNull
    private Long id_course;
    private String start_date;

    @NotNull
    private Boolean activity;
}

