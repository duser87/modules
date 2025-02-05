package ru.innopolis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCourseResponse {
    private Long id;
    private Long id_student;
    private Long id_course;
    private String message;
}
