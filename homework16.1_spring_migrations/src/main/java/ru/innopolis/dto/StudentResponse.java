package ru.innopolis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {
        private Long id;
        private String fio;
        private String email;
        private Integer age;
        private String course;
        private String message;
        private HashMap<String, String> review;
}
