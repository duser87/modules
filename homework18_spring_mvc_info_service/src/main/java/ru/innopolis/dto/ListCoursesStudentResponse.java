package ru.innopolis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListCoursesStudentResponse {
    private Long id;
    private Long idStudent;
    private Long idCourses;
    private String dateStart;
    private Boolean activity;
}
