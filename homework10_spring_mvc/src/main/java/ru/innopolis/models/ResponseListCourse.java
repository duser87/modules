package ru.innopolis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListCourse {
    private Long id;
    private Long id_student;
    private Long id_course;
}
