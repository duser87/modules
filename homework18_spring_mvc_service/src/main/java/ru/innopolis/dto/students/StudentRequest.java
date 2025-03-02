package ru.innopolis.dto.students;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {
    //private String fio;
    private Long idStudent;
    private Long idCourse;
    private String review;
}