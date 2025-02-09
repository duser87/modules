package ru.innopolis.entities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCoursesEntity {
    private Long id;
    @NotNull
    private Long id_student;
    @NotNull
    private Long id_course;
    private String start_date;
    @NotNull
    private Long activity;
}
