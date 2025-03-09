package ru.innopolis.dto.students;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {
    private Long id;
    private String fio;
    private String email;
    private Integer age;
    private String[] courses;
    private String message;
}