package ru.innopolis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoEntity {
    private Long idStudent;
    private String fio;
    private String nameCourse;
    private Boolean archive;
    private String message;
}
