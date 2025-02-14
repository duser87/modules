package ru.innopolis.dto.courses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
        private Long id;
        private String name;
        private Boolean activity;
}
