package ru.innopolis.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCourses {
    private Long id;

    @NotNull
    private Long id_student;

    @NotNull
    private Long id_source;
}
