package ru.innopolis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordStudentResponse {
    private String fio;
    private String course;
    private String message;
}
